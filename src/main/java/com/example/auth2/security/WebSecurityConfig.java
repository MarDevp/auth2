package com.example.auth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.auth2.security.jwt.AuthEntryPointJwt;
import  com.example.auth2.security.jwt.AuthTokenFilter;
import com.example.auth2.security.services.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;
    // This class is responsible for handling unauthorized access attempts by returning an error response.

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }
    // The authenticationJwtTokenFilter() method creates a new instance of the AuthTokenFilter class. This filter is responsible for validating the JWT token sent in the authorization header of each request.

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests().requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/projects").permitAll()
                .requestMatchers("/api/createProject").permitAll()
                .requestMatchers("/api/updateProject/**").permitAll()
                .requestMatchers("/api/deleteProject/**").permitAll()
                .requestMatchers("/api/projectById/**").permitAll()
                .requestMatchers("/api/objectifs").permitAll()
                .requestMatchers("/api/createObjectif").permitAll()
                .requestMatchers("/api/updateObjectif/**").permitAll()
                .requestMatchers("/api/deleteObjectif/**").permitAll()
                .requestMatchers("/api/resultats").permitAll()
                .requestMatchers("/api/createResultat").permitAll()
                .requestMatchers("/api/updateResultat/**").permitAll()
                .requestMatchers("/api/deleteResultat/**").permitAll()
                .requestMatchers("/api/indicateurs").permitAll()
                .requestMatchers("/api/createIndicateur").permitAll()
                .requestMatchers("/api/updateIndicateur/**").permitAll()
                .requestMatchers("/api/deleteIndicateur/**").permitAll()
                .requestMatchers("/api/indicateurPlan").permitAll()
                .requestMatchers("/api/createIndicateurPlan").permitAll()
                .requestMatchers("/api/updateIndicateurPlan/**").permitAll()
                .requestMatchers("/api/deleteIndicateurPlan/**").permitAll()
                .requestMatchers("/api/auth/login/**").permitAll()
                .requestMatchers("/api/users").permitAll()
                .requestMatchers("/api/userById/**").permitAll()
                .requestMatchers("/api/createUser").permitAll()
                .requestMatchers("/api/updateUser/**").permitAll()
                .requestMatchers("/api/deleteUser/**").permitAll()
                .requestMatchers("/api/activites").permitAll()
                .requestMatchers("/api/createActivite").permitAll()
                .requestMatchers("/api/updateActivite/**").permitAll()
                .requestMatchers("/api/deleteActivite/**").permitAll()
                .requestMatchers("/api/indicateursValeurs").permitAll()
                .requestMatchers("/api/createIndicateurValeur").permitAll()
                .requestMatchers("/api/deleteIndicateurvaleur/**").permitAll()
                .requestMatchers("/api/updateIndicateurValeur/**").permitAll()
                .requestMatchers("/api/notifications").permitAll()
                .requestMatchers("/api/createNotification").permitAll()
                .requestMatchers("/api/updateNotification/**").permitAll()
                .requestMatchers("/api/deleteNotification/**").permitAll()
                .requestMatchers("/api/objectif_projet/**").permitAll()
                .requestMatchers("/api/resultat_objectif/**").permitAll()




                .anyRequest().authenticated()
        .and().csrf().disable();

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }



}
