package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Damage;
import com.example.projekt3_gruppe_2.Model.damageReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class damageReportRepo {

    @Autowired
    DataSource dataSource;

    public damageReport getDamageReportById(int id) {
        String sql = "SELECT * FROM damageReport WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Date date = resultSet.getDate("inspection_date");
                    int totalPrice = resultSet.getInt("priceTotal");

                    damageReport report = new damageReport(id, date, totalPrice);
                    
                    // Fetch damages
                    report.setDamages(getDamagesByReportId(id));
                    
                    return report;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Damage> getDamagesByReportId(int reportId) {
        List<Damage> damages = new ArrayList<>();
        String sql = "SELECT * FROM damage WHERE damageReport_id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reportId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String desc = resultSet.getString("damageDescription");
                    int price = resultSet.getInt("price");

                    damages.add(new Damage(id, desc, price, reportId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return damages;
    }
}
