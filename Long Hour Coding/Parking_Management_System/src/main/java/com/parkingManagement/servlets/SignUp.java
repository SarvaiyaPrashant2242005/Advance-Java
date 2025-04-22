package com.parkingManagement.servlets;

import com.parkingManagement.dao.UserDao;
import com.parkingManagement.model.Users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyName = request.getParameter("company_name");
        String companyEmail = request.getParameter("company_email");
        String companyPhone = request.getParameter("company_phone");
        String companyAddress = request.getParameter("company_address");
        int parkingSlots = Integer.parseInt(request.getParameter("parking_slots"));
        String password = request.getParameter("password");

        Users newUser = new Users(companyName, companyEmail, companyPhone, companyAddress, parkingSlots, password);

        if (userDao.registerUser(newUser)) {
            response.sendRedirect("SignIn-page.jsp");
        } else {
            response.sendRedirect("signup.jsp?error=Registration failed");
        }
    }
}
