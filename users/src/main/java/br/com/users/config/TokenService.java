package br.com.users.config;

import br.com.users.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private Long expiration;

    private String secret;

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        Date date = new Date();

        long expirationDate = date.getTime() + expiration;

        Date expiration = new Date(expirationDate);

        return Jwts.builder()
                .setIssuer("Users")
                .setSubject(user.getId().toString())
                .setIssuedAt(date)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }
}
