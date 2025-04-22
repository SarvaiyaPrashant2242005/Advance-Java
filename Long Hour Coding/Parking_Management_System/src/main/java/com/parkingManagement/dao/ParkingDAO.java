package com.parkingManagement.dao;

import com.parkingManagement.model.Parking;
import com.parkingManagement.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingDAO {

    // Retrieve all parkings for a specific company
    public List<Parking> getAllParkings(String companyName) {
        List<Parking> parkingList = new ArrayList<>();
        String query = "SELECT * FROM parking WHERE company_name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, companyName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Parking parking = new Parking();
                parking.setId(rs.getInt("id"));
                parking.setVehicleNumber(rs.getString("vehicle_number"));
                parking.setDuration(rs.getInt("duration"));
                parking.setCompanyName(rs.getString("company_name"));
                parking.setEntryTime(rs.getTimestamp("entry_time"));
                parking.setExitTime(rs.getTimestamp("exit_time"));
                parking.setFine(rs.getDouble("fine"));

                parkingList.add(parking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkingList;
    }

    // Add new parking record
    public void addParking(Parking parking) {
        String query = "INSERT INTO parking (vehicle_number, duration, company_name, entry_time, exit_time, fine) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, parking.getVehicleNumber());
            stmt.setInt(2, parking.getDuration());
            stmt.setString(3, parking.getCompanyName());
            stmt.setTimestamp(4, parking.getEntryTime());
            stmt.setTimestamp(5, parking.getExitTime());
            stmt.setDouble(6, parking.getFine());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update parking record
    public void updateParking(Parking parking) {
        String query = "UPDATE parking SET vehicle_number=?, duration=?, entry_time=?, exit_time=?, fine=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, parking.getVehicleNumber());
            stmt.setInt(2, parking.getDuration());
            stmt.setTimestamp(3, parking.getEntryTime());
            stmt.setTimestamp(4, parking.getExitTime());
            stmt.setDouble(5, parking.getFine());
            stmt.setInt(6, parking.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete parking record
    public void deleteParking(int id) {
        String query = "DELETE FROM parking WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
