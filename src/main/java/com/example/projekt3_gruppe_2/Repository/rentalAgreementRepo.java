package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.rentalAgreement;
import com.example.projekt3_gruppe_2.Model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

@Repository
public class rentalAgreementRepo {

    @Autowired
    DataSource dataSource;

    public rentalAgreement getRentalAgreementById(int id) {
        String sql = "SELECT * FROM rentalAgreement WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int price = resultSet.getInt("price");
                    Date startDate = resultSet.getDate("startDate");
                    Date endDate = resultSet.getDate("endDate");
                    int costumerId = resultSet.getInt("costumer_id");
                    
                    String pickupStr = resultSet.getString("pickup");
                    Location location = null;
                    if (pickupStr != null) {
                        try {
                            location = Location.valueOf(pickupStr);
                        } catch (IllegalArgumentException e) {
                            // Enum string didn't match
                        }
                    }

                    return new rentalAgreement(id, startDate, endDate, price, location, costumerId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
