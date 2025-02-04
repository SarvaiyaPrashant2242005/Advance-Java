package com.prashantsarvaiya.servletTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/scfirst")
public class ServletCookiesFirst extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        out.println("<form action='scsecond'>");
        out.println("<input type='text' name='txtData' />");
        out.println("<input type='submit' name='btnGo' value='GO' />");
        out.println("</form>");

    }
}
