package com.api.products.Middleware;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.api.products.services.api.UserService;
import com.api.products.utils.authUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.core.ipc.http.HttpSender.Method;



@Component
public class Authentication extends OncePerRequestFilter {

    @Autowired
     UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
        
           // userService.authenticate(request.getHeader("authorization"));
            userService.authenticate(request.getHeader("user"),request.getHeader("psw"));
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
        }
    }

    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        
		return request.getMethod().equals("GET");
	}



}
