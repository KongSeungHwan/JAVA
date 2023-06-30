package com.matchgetit.backend.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //restApi에서는 csrf 인증 필요x
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests()
                .requestMatchers("/matchGetIt/auth/**").permitAll()
                .requestMatchers("/matchGetIt/auth/session").permitAll()
                .requestMatchers("/matchGetIt/auth/token").permitAll()
                .requestMatchers("/matchGetIt/naver/**").permitAll()
                .requestMatchers("/css/**").permitAll()//예외 페이지 구성
                .anyRequest().access("@securityConfig.hasValidToken(request)");
        return http.build();
    }//세션에 있는 토큰을 인증하는 로직

    public boolean hasValidToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String headerToken = request.getHeader("Authorization");
        if(headerToken!=null){
        headerToken = headerToken.substring(7);
            return jwtTokenProvider.validateToken(headerToken);
        }
        if (token != null) {
            System.out.println(jwtTokenProvider.validateToken(token));
            return jwtTokenProvider.validateToken(token);
        }else{
            return false;
        }
    }//jwt 토큰 인증을 마쳐야 true가 뜨고 접근 가능함!
}