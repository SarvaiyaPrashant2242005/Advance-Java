package com.parkingManagement.servlets;

import com.parkingManagement.dao.VehicleTypeDAO;
import com.parkingManagement.model.Users;
import com.parkingManagement.model.VehicleType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/Vehicle")
public class VehicleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get the user session
            HttpSession session = request.getSession();
            Users user = (Users) session.getAttribute("user");

            // Check if user session exists
            if (user == null) {
                response.getWriter().println("Error: User session not found. Please log in.");
                return;
            }

            int companyId = user.getId();
            if (companyId <= 0) {
                response.getWriter().println("Error: Invalid company ID.");
                return;
            }


            // Get vehicle pricing details from the form
            String[] vehicleTypes = request.getParameterValues("vehicle_type[]");
            String[] prices = request.getParameterValues("price[]");
            String[] fines = request.getParameterValues("fine[]");


            // Get database connection
            Connection connection = (Connection) getServletContext().getAttribute("DBConnection");
            if (connection == null) {
                response.getWriter().println("Error: Database connection not found.");
                return;
            }

            VehicleTypeDAO vehicleTypeDAO = new VehicleTypeDAO(connection);

            // Loop through and save each vehicle type
            for (int i = 0; i < vehicleTypes.length; i++) {
                VehicleType vehicleType = new VehicleType();
                vehicleType.setCompanyId(companyId);
                vehicleType.setVehicleType(vehicleTypes[i]);
                vehicleType.setVehicleCharge(Double.parseDouble(prices[i]));
                vehicleType.setFine(Double.parseDouble(fines[i]));

                boolean isInserted = vehicleTypeDAO.saveVehiclePricing(vehicleType);
                System.out.println("Inserted: " + isInserted + " for " + vehicleTypes[i]);

                if (!isInserted) {
                    response.getWriter().println("Error: Could not insert " + vehicleTypes[i]);
                    return;
                }
            }

            // Redirect after saving
            response.sendRedirect("vehicles.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while processing the request");
        }
    }
}
