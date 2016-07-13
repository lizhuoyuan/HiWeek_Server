package com.HiWeek.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "EncodeFilter", urlPatterns = { "/servlet/*" }, initParams = { @WebInitParam(name = "encode", value = "UTF-8") }, asyncSupported = true)
public class EncodeFilter implements Filter {
    String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding(encode);
        response.setCharacterEncoding(encode);
        response.setContentType("text/html;charset = " + encode);
        // response.setContentType(text/image);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
