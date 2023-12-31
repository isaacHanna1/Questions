package com.common;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CharacterEncodingFilter implements Filter { 
    private FilterConfig fc; 

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req; 
        HttpServletResponse response = (HttpServletResponse) resp; 
        request.setCharacterEncoding("UTF8"); 
        response.setCharacterEncoding("UTF8"); 

        chain.doFilter(request, response); 

        request.setCharacterEncoding("UTF8"); 
        response.setCharacterEncoding("UTF8"); 
    }

    @Override
    public void destroy() {
    
    }
    
    
}
