package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()  // Permite acesso ao Swagger sem autenticação
                        .requestMatchers("/api/users/**").authenticated()  // Protege as rotas da API de usuários
                        .anyRequest().permitAll()  // Permite acesso a outras rotas sem autenticação
                )
                .oauth2Login();  // Configura OAuth2 Login

        return http.build();
    }
}
