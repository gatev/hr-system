package com.hrsystem.holidaymanagement.security.jwt;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    
    @Value("${hrSystem.secretKey}")
    private String secretKey;

    public List<SimpleGrantedAuthority> getUserRoleFromToken(String token) {
    	List<SimpleGrantedAuthority> result = new LinkedList<>();
    	StringBuilder roles = new StringBuilder(Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody().get("roles").toString());
    	roles.deleteCharAt(0);
    	roles.deleteCharAt(roles.length() - 1);
    	String[] rolesArr = roles.toString().split(",");
    	for (int i = 0; i < rolesArr.length; i++) {
    		result.add(new SimpleGrantedAuthority(rolesArr[i]));
		}
    	return result ;
    }

}
