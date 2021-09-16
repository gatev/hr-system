package com.hrsystem.usermanagement.payload.response;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

import java.util.Collection;

@Data
public class JwtResponse {
	private Long id;
    private String token;
    private String type = "Bearer";
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(Long id, String accessToken, String email, Collection<? extends GrantedAuthority> authorities) {
    	this.id = id;
        this.token = accessToken;
        this.email = email;
        this.authorities = authorities;
    }

}
