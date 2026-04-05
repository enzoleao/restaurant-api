package com.example.basicapi.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.example.basicapi.entity.User;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import java.util.Date;


@Service
public class JwtService {
    private final String JWT_SECRET = "Secret_JWT";
    private final Integer JWT_EXPIRES = 87000000;

    public String generateToken(User user) {
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_EXPIRES))
                .sign(Algorithm.HMAC256(JWT_SECRET));
    }
}
