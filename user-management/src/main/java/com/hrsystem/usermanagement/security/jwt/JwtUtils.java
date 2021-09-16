package com.hrsystem.usermanagement.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.hrsystem.usermanagement.security.service.UserDetailsImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${hrSystem.expirationMs}")
    private Long jwtExpirationMs; // 1 hour
    
    @Value("${hrSystem.secretKey}")
    private String secretKey;
    
    public String generateJwtToken(Authentication authentication, boolean isRememberMe) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        
        if (isRememberMe) {
        	jwtExpirationMs = jwtExpirationMs * 24 * 30; // 30 days
        }

        return Jwts.builder()
                .setSubject((userPrincipal.getEmail()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, this.secretKey)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody().getSubject();
    }

}
