package vn.haphan.msmultitenanttask.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

/**
 * @author : Hà Phan
 * created date : 2/24/2026
 * project-name : ms-learn-spring40
 * package-name : vn.haphan.msmultitenanttask.config
 **/
@Service
public class JwtService {

    private final SecretKey SECRET;

    public JwtService(@Value("${jwt.secret}") String secretString) {
        byte[] keyBytes = Base64.getDecoder().decode(secretString);
        this.SECRET = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String userId, String tenantId) {
        return Jwts.builder()
                .subject(userId)
                .claim("tenantId", tenantId)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SECRET)
                .compact();
    }

    public Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(SECRET)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
