package com.vhbeltramini.dronezeta.service.component;

import com.vhbeltramini.dronezeta.utils.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TokenValidationInterceptor implements HandlerInterceptor {

    private JwtTokenProvider jwtTokenProvider;


    @Autowired
    public TokenValidationInterceptor(JwtTokenProvider tokenProvider) {
        this.jwtTokenProvider = tokenProvider;

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        return jwtTokenProvider.validateToken(token); // Token is valid, continue processing the request
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
