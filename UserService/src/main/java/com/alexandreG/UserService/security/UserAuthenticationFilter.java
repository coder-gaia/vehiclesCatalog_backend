package com.alexandreG.UserService.security;

import com.alexandreG.UserService.models.ModelUser;
import com.alexandreG.UserService.models.ModelUserDetailsImpl;
import com.alexandreG.UserService.repository.IUserRepository;
import com.alexandreG.UserService.service.JwtTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!checkPublicEndpoints(request)) {
            String token = recoverToken(request);
            if (token != null) {
                String subject = jwtTokenService.getToken(token);
                Optional<ModelUser> optionalModelUser = userRepository.findByUsername(subject);

                if (optionalModelUser.isPresent()) {
                    ModelUser modelUser = optionalModelUser.get();
                    ModelUserDetailsImpl modelUserDetails = new ModelUserDetailsImpl(modelUser);
                    Authentication authentication =
                            new UsernamePasswordAuthenticationToken(
                                    modelUserDetails.getUsername(),
                                    null,
                                    modelUserDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean checkPublicEndpoints(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        return Arrays.asList("/api/users/login", "/api/users").contains(requestURI);
    }

    private String recoverToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}
