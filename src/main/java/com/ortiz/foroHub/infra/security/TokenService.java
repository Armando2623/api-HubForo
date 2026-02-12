package com.ortiz.foroHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import com.ortiz.foroHub.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("foroHub")
                    .withSubject(usuario.getCorreo())
                    .withExpiresAt(fechaexpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al generar el JWT", exception);
        }
    }

    private Instant fechaexpiracion() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));

    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)

                    .withIssuer("foroHub")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();


        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT invalido o expirado");
        }
    }
}