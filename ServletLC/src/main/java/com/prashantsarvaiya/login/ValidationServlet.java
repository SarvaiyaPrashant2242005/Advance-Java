package com.prashantsarvaiya.login;
import com.prashantsarvaiya.connection.MyConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req, resp);
    }

    void validate(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        String unm = req.getParameter("uname");
        String pd = req.getParameter("password");
        MyConn conn = MyConn.getInstance();

        PrintWriter out = resp.getWriter();
        String res = conn.validateUser(unm,pd);
        if(!res.equals("No user Found")){
            out.print("Welcome "+res);
        }
        else {
            out.print("invalid credentials "+res);
        }
    }
}