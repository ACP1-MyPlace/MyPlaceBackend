package com.acp1.myplace.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.acp1.myplace.services.JwtManager;

@Component
@ConditionalOnProperty(value="environment",havingValue="production")
public class JwtFilter extends OncePerRequestFilter {


    private static final int TOKEN_START = 7;

    private UserDetailsService userDetailsSecurityService;
    private JwtManager jwtManager;

    public JwtFilter(UserDetailsService userDetailsSecurityService, JwtManager jwtManager) {
        this.userDetailsSecurityService = userDetailsSecurityService;
        this.jwtManager = jwtManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        String mail = null;
        String token = null;

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            token = authorizationHeader.substring(TOKEN_START);
            mail = jwtManager.getMailFromToken(token);
        }

        if(mail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            var userDetails = this.userDetailsSecurityService.loadUserByUsername(mail);
            if(jwtManager.validateToken(token, userDetails)){
                var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

}
