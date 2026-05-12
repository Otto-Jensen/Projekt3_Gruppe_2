package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Model.Status;
import com.example.projekt3_gruppe_2.Model.damageReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class damageReportRepo {

    @Autowired
    DataSource dataSource;

    public ArrayList<damageReport> getAllReports(){
        ArrayList<damageReport> reportList = new ArrayList<>();
        String sql="SELECT * FROM damageReport";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement =connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                damageReport dmgReport = new damageReport();
                dmgReport.setId(resultSet.getInt("id"));
                dmgReport.setDate(resultSet.getDate("inspection_date"));
                dmgReport.setTotalPrice(resultSet.getInt("priceTotal"));


                reportList.add(dmgReport);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return reportList;
    }

    public damageReport getDamageReportbyId(int id){
        damageReport dmgReport = new damageReport();
        String sql ="SELECT * FROM damageReport WHERE  id=?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    dmgReport.setId(resultSet.getInt("id"));
                    dmgReport.setDate(resultSet.getDate("inspection_date"));
                    dmgReport.setTotalPrice(resultSet.getInt("priceTotal"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return dmgReport;
    }

    public void deleteDamageReport(int id){
        String sql="DELETE FROM damageReport WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveDamageReport (damageReport dmgReport){
        String sql="INSERT INTO damageReport(inspection_date, priceTotal) VALUES (?,?)";

        try (Connection connection=dataSource.getConnection();
             PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setDate(1,new java.sql.Date(dmgReport.getDate().getTime()));
            statement.setInt(2,dmgReport.getTotalPrice());

            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public int getLastInstertedId(){
        String sql="SELECT LAST_INSERT_ID()";
        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            if(resultSet.next()){
                return resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
