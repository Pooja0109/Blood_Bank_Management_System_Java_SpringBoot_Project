package com.dal.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.dal.entity.AuthUsers;
import com.dal.repository.AuthUserRepository;

@Component
public class BloodBankAuthProvider implements AuthenticationProvider{
	
	@Autowired
	AuthUserRepository authUserRepository;

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

	        String username = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        AuthUsers authUser = authUserRepository.findByUsername(username);

	        if (authUser == null) {
	            System.out.println("User not found");
	        } else if (password.equals(authUser.getPassword())) {
	            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
	        } else {
	        	System.out.println("Invalid password");
	        	
	        }
	        return null;
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	    }
}
