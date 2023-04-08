package com.example.auth2.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import com.example.auth2.models.Erole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth2.models.Role;
import com.example.auth2.models.User;
import com.example.auth2.payload.request.LoginRequest;
import com.example.auth2.payload.request.SignupRequest;
import com.example.auth2.payload.response.UserInfoResponse;
import com.example.auth2.payload.response.MessageResponse;
import com.example.auth2.repository.RoleRepository;
import com.example.auth2.repository.UserRepository;
import com.example.auth2.security.jwt.JwtUtils;
import com.example.auth2.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600,allowCredentials="true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role observateurRole = roleRepository.findByName(Erole.ROLE_OBSERVATEUR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(observateurRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(Erole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "evaluateur":
                        Role evaluateurRole = roleRepository.findByName(Erole.ROLE_EVALUATEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(evaluateurRole);

                        break;

                    case "gestionnaire":
                        Role gestionnaireRole = roleRepository.findByName(Erole.ROLE_GESTIONNAIRE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(gestionnaireRole);

                        break;
                    default:
                        Role observateurRole = roleRepository.findByName(Erole.ROLE_OBSERVATEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(observateurRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
