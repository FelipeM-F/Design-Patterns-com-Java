package com.example.spring_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login
                                .defaultSuccessUrl("/swagger-ui/index.html", true)
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // URL para o logout
                                .logoutSuccessUrl("/") // Redireciona para a página inicial após o logout
                                .invalidateHttpSession(true) // Invalida a sessão
                                .deleteCookies("JSESSIONID") // Deleta o cookie da sessão
                )
                .csrf(csrf -> csrf.disable()); // Desativa CSRF para simplificar o teste

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/resources/**");
    }
}