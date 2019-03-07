package ru.aponkin.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SingInFilter implements Filter {

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if (request.getRequestURI().contains("/singin") || request.getRequestURI().contains("/create") || request.getRequestURI().contains("/country-city")) {
            System.out.println();
        } else if (session.getAttribute("registeredUser") == null) {
            req.getRequestDispatcher("/WEB-INF/view/SingIn.jsp").forward(req, resp);
        }
        chain.doFilter(req, resp);
    }
}