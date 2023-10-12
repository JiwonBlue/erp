package erp.backend.global.config.security;

import erp.backend.global.config.security.jwt.JwtAuthenticationEntryPoint;
import erp.backend.global.config.security.jwt.JwtSecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final JwtSecurityFilter jwtSecurityFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(handling -> handling.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(
                                        "/api/notice/**",
                                        "/api/notice/management/**",
                                        "/api/salary/**"
                                ).hasAnyRole("ADMIN_인사부", "ADMIN_재무부", "ADMIN_콘텐츠관리부", "ADMIN_회원관리부")
                                .requestMatchers(
                                        "/main",
                                        "/api/log/commute",
                                        "/api/schedule",
                                        "/api/emp/fix-info",
                                        "/api/emp/approval",
                                        "/api/emp/approval-success",
                                        "/api/comment/board/**",
                                        "/api/emp/main"
                                ).hasAnyRole("USER_인사부", "USER_재무부", "USER_콘텐츠관리부", "USER_회원관리부")
                                .requestMatchers(
                                        "/api/emp/sign-in",
                                        "/api/emp/sign-up",
                                        "/api/notice/list",
                                        "/api/notice/detail",
                                        "/api/memo/**",
                                        "/api/emp/list",
                                        "/api/emp/list/**",
                                        "/api/vacation/list",
                                        "/api/vacation/insert",
                                        "/api/vacation/update/**",
                                        "/api/board/**",
                                        "/api/comment/board/**",
                                        "/api/comment/board/{boardId}/**",
                                        "/api/comment/board/{boardId}/commentDelete/**"
                                ).permitAll()
                                .anyRequest().hasRole("USER")
                )
                .addFilterBefore(jwtSecurityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowCredentials(true);
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        // TODO 운영반영 시 addAllowedOriginPattern(https://domain.com) 주소로 변경
        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
