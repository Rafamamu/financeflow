package com.rafamamu.financeflow.config;

import com.rafamamu.financeflow.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public  class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain filterChain) throws ServletException, IOException {

        System.out.println("=== JwtAuthFilter Executado ===");
        String bearerToken = request.getHeader("Authorization");
        System.out.println("Token recebido: "+ bearerToken);

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            String token = bearerToken.substring(7);
            String email = jwtService.validateToken(token);
            System.out.println("Token validado para email: "+ email);

            UsernamePasswordAuthenticationToken certified =
                    new UsernamePasswordAuthenticationToken(
                            email,
                            null,
                            List.of());

            SecurityContextHolder.getContext().setAuthentication(certified);
            System.out.println("Autenticação setada no SecurityContext");
        }

        filterChain.doFilter(request,response);


    }
}
