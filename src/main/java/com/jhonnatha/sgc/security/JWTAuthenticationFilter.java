package com.jhonnatha.sgc.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhonnatha.sgc.dto.CredenciaisDTO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

private AuthenticationManager authenticationManager;

private JWTUtil jwtUtil;

public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
	setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
    this.authenticationManager = authenticationManager;
    this.jwtUtil = jwtUtil;
}

@Override
public Authentication attemptAuthentication(HttpServletRequest req,
                                            HttpServletResponse res) throws AuthenticationException {

	try {
		CredenciaisDTO creds = new ObjectMapper()
                .readValue(req.getInputStream(), CredenciaisDTO.class);

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
        
        Authentication auth = authenticationManager.authenticate(authToken);
        return auth;
	}
	catch (IOException e) {
		throw new RuntimeException(e);
	}
}

@Override
protected void successfulAuthentication(HttpServletRequest req,
                                        HttpServletResponse res,
                                        FilterChain chain,
                                        Authentication auth) throws IOException, ServletException {

	String username = ((UserSS) auth.getPrincipal()).getUsername();
	String id = ((UserSS) auth.getPrincipal()).getId();
    String token = jwtUtil.generateToken(username);
    res.addHeader("Authorization", "Bearer " + token);
    res.addHeader("access-control-expose-headers", "Authorization");
    res.setContentType("application/json");
    res.setCharacterEncoding("UTF-8");
    res.getWriter().write(
            "{\"id\": \"" + id + "\", \"username\": \"" +username +"\"}"
    );
}

private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
	 
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.setStatus(401);
        response.setContentType("application/json"); 
        response.getWriter().append(json());
    }
    
    private String json() {
        long date = new Date().getTime();
        return "{\"timestamp\": " + date + ", "
            + "\"status\": 401, "
            + "\"error\": \"Não autorizado\", "
            + "\"message\": \"Email ou senha inválidos\", "
            + "\"path\": \"/login\"}";
    }
}

}
