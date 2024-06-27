package com.rgomes.mobiauto_backend_interview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .requestMatchers("/store/**").hasAnyRole("PROPRIETARIO", "GERENTE", "ASSISTENTE")
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin.permitAll())
            .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
 

    
}
