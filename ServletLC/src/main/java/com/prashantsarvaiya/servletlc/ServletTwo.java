package com.prashantsarvaiya.servletlc;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet-two")
public class ServletTwo extends GenericServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method called - Servlet 2");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig method called -  Servlet 2");
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service method called -  Servlet 2");
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.println("from service call");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo method called -  Servlet 2");
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("destroy method called -  Servlet 2");
    }

}