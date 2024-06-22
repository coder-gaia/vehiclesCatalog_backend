/**
 * @author alexandre.gaia
 */

package com.alexandreG.UserService.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import com.alexandreG.UserService.models.ModelUserDetailsImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class JwtTokenService {

    @Value("${token.jwt.secret.key}")
    private String secret_Key;

    @Value("${token.jwt.issuer}")
    private String issuer;

    public String generateToken(ModelUserDetailsImpl user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret_Key);
            return JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating token: ", exception);
        }
    }

    public String getToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret_Key);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Token inválido ou expirado!");
        }
    }

    public String getUsernameFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret_Key);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid or expired token!", exception);
        }
    }

    public boolean validateToken(String token, String username) {
        final String tokenUsername = getUsernameFromToken(token);
        return (tokenUsername.equals(username));
    }

}
