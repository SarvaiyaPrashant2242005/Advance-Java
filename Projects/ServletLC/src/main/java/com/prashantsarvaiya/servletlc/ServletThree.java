package com.prashantsarvaiya.servletlc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet-three")
public class ServletThree extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init method called - Servlet 3");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig method called- Servlet 3");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Service method called - Servlet 3");  //generated the output
        PrintWriter out = servletResponse.getWriter();
        out.println("From Service Call - Hey Prashant - Servlet 3");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Service method called");  //generated the output
        PrintWriter out = resp.getWriter();
        out.println("From Service Call - Hey Prashant - Servlet 3");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo method called = Servlet 3");
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("Destored - Servlet 3");
    }
}
