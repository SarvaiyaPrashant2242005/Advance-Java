package com.parkingManagement.dao;

import com.parkingManagement.model.VehicleType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleTypeDAO {
    private Connection connection;

    public VehicleTypeDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to save vehicle pricing to the database
    public boolean saveVehiclePricing(VehicleType vehicleType) {
        String query = "INSERT INTO vehicle_types (company_id, vehicle_type, vehicle_charge, fine) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vehicleType.getCompanyId());
            stmt.setString(2, vehicleType.getVehicleType());
            stmt.setString(3, vehicleType.getVehicleCharge());
            stmt.setString(4, vehicleType.getFine());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to get all vehicle types for a specific company
    public List<VehicleType> getVehicleTypesByCompanyId(int companyId) {
        List<VehicleType> vehicleTypes = new ArrayList<>();
        String query = "SELECT * FROM vehicle_types WHERE company_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, companyId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                VehicleType vehicleType = new VehicleType();
                vehicleType.setId(rs.getInt("id"));
                vehicleType.setCompanyId(rs.getInt("company_id"));
                vehicleType.setVehicleType(rs.getString("vehicle_type"));
                vehicleType.setVehicleCharge(rs.getDouble("vehicle_charge"));
                vehicleType.setFine(rs.getDouble("fine"));
                vehicleTypes.add(vehicleType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleTypes;
    }
}
