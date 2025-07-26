package org.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebFilter("/attendance")
public class RoleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if (!Objects.isNull(session)
                && "teacher".equalsIgnoreCase((String) session.getAttribute("role"))) {
            chain.doFilter(request, response);
        } else {
            resp.getWriter().println("У вас нет доступа к этой странице");
        }
    }
}
