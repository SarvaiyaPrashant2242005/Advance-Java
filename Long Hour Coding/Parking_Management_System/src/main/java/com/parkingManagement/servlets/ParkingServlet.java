package com.parkingManagement.servlets;

import com.parkingManagement.dao.ParkingDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParkingServlet")
public class ParkingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParkingDAO parkingDAO = new ParkingDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            parkingDAO.deleteParking(id);
        }

    }
}
