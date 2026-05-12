package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Costumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class costumerRepo {

    @Autowired
    DataSource dataSource;

    public ArrayList<Costumer> getAllCostumer(){
        ArrayList <Costumer> costumerList = new ArrayList<>();
        String sql="SELECT * FROM costumer";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement =connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                Costumer costumer = new Costumer();
                costumer.setId(resultSet.getInt("id"));
                costumer.setName(resultSet.getString("costumer_name"));
                costumer.setPhoneNumber(resultSet.getInt("phoneNumber"));
                costumer.setEmail(resultSet.getString("Email"));

                costumerList.add(costumer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return costumerList;
    }


public Costumer getCostumerbyId(int id){
    Costumer costumer = new Costumer();
    String sql ="SELECT * FROM costumer WHERE id=?";

    try(Connection connection = dataSource.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id);

        try(ResultSet resultSet=statement.executeQuery()){
            if(resultSet.next()){
                costumer.setId(resultSet.getInt("id"));
                costumer.setName(resultSet.getString("costumer_name"));
                costumer.setPhoneNumber(resultSet.getInt("phoneNumber"));
                costumer.setEmail(resultSet.getString("Email"));
            }
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return costumer;
    }


    public void deleteCostumer(int id){
        String sql="DELETE  FROM costumer WHERE id=?";

        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void saveCostumer(Costumer costumer){
       String sql="INSERT INTO costumer(costumer_name, phoneNumber, Email) VALUES (?,?,?)";

       try(Connection connection = dataSource.getConnection();
       PreparedStatement statement=connection.prepareStatement(sql)){
           statement.setString(1,costumer.getName());
           statement.setInt(2,costumer.getPhoneNumber());
           statement.setString(3,costumer.getEmail());

           statement.executeUpdate();

       }catch (SQLException e){
           e.printStackTrace();
       }
    }
}
