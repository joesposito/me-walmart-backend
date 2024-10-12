package com.walmart.api.Walmart.API.securityconfig;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {
    private static final Logger logger = LogManager.getLogger(SecurityConfig.class);

    // TODO: Implement user database.
    // Builds standard user with dummy credentials for request-making tests.
    @Bean
    public UserDetailsService UserDetailsService(){
        UserDetails userDetails = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER")
                .build();

        InMemoryUserDetailsManager imud = new InMemoryUserDetailsManager();
        imud.createUser(userDetails);
        return imud;
    }


    // Uses dummy password encoder for now, since I overrode the SecurityFilterChain.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        try{
            // Sets the CORS policy by allowing requests from React frontend.
            http.cors(c -> {
                CorsConfigurationSource source = request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(List.of("http://localhost:3000"));
                    config.setAllowedMethods(List.of("GET", "PUT", "POST", "DELETE", "PATCH"));
                    config.setAllowedHeaders(List.of("*"));
                    return config;
                };

                c.configurationSource(source);
            });

            // TODO: CSRF is disabled.
            http.csrf(c -> {
                c.disable();
            });

            http.authorizeHttpRequests(authorize -> {
                authorize.anyRequest().permitAll();
            });

            return http.build();
        }catch(Exception e){
            logger.error("Unable to create SecurityFilterChain bean.", e);
            return null;
        }
    }
}
