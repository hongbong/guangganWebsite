package com.guanggan.website.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @NAME: LoginCheckFilter
 * @USER: hongbong
 * @DATE: 2023/4/6
 * @TIME: 19:00
 **/

@Slf4j
@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
