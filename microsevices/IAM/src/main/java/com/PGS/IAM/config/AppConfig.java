package com.PGS.IAM.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@EnableAspectJAutoProxy()
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement(management ->
                        management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/api/**").authenticated() // API nécessite une authentification
                                .requestMatchers("/graphql", "/graphiql/**").permitAll() // GraphQL et GraphiQL accessibles sans authentification
                                .anyRequest().permitAll() // Tout le reste est accessible
                )
                .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Configurer CORS
                .formLogin(withDefaults()); // Activer formLogin par défaut

        return http.build();
    }





    private CorsConfigurationSource corsConfigurationSource() {
        return new CorsConfigurationSource() {

            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {


                CorsConfiguration cfg = new CorsConfiguration();
                cfg.setAllowedOrigins(Collections.singletonList("*"));
                cfg.setAllowedMethods(Collections.singletonList("*"));
                cfg.setAllowedHeaders(Collections.singletonList("*"));
                cfg.setExposedHeaders(Collections.singletonList("*"));
                cfg.setMaxAge(3600L);
                return cfg;
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}