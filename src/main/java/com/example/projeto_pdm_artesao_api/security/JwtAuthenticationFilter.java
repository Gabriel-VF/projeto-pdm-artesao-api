package com.example.projeto_pdm_artesao_api.security;

import com.example.projeto_pdm_artesao_api.entities.Artesao;
import com.example.projeto_pdm_artesao_api.repositories.ArtesaoRepository;
import com.example.projeto_pdm_artesao_api.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final ArtesaoRepository artesaoRepository;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            ArtesaoRepository artesaoRepository
    ) {
        this.jwtService = jwtService;
        this.artesaoRepository = artesaoRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader =
                request.getHeader("Authorization");

        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {

            String email =
                    jwtService.extractEmail(token);

            Artesao artesao =
                    artesaoRepository
                            .findByEmail(email)
                            .orElse(null);

            if (artesao != null &&
                    jwtService.isTokenValid(token, artesao)) {

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                artesao,
                                null,
                                Collections.emptyList()
                        );

                SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication);
            }

        } catch (Exception e) {

            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}