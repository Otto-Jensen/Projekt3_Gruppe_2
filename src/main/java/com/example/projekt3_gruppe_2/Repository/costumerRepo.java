package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Costumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class costumerRepo {

    @Autowired
    DataSource dataSource;

    public Costumer getCostumerById(int id) {
        String sql = "SELECT * FROM costumer WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("costumer_name");
                    int phoneNumber = resultSet.getInt("phoneNumber");
                    String email = resultSet.getString("Email");

                    return new Costumer(id, name, phoneNumber, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
