package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Location;
import com.example.projekt3_gruppe_2.Model.rentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.transaction.autoconfigure.TransactionManagerCustomizers;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class rentalAgreementRepo {


    @Autowired
    DataSource dataSource;


    public ArrayList<rentalAgreement> getAllRentals() {

        ArrayList<rentalAgreement> rentalList = new ArrayList<>();
        String sql = "SELECT * FROM rentalAgreement";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                rentalAgreement rental = new rentalAgreement();
                rental.setId(resultSet.getInt("id"));
                rental.setStartDato(resultSet.getDate("startDate"));
                rental.setEndDate(resultSet.getDate("endDate"));
                rental.setPrice(resultSet.getInt("price"));

                String locationString =resultSet.getString("pickup");
                rental.setLocation(Location.valueOf(locationString));
                rental.setCustomerId(resultSet.getObject("costumer_id", Integer.class));

                rentalList.add(rental);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rentalList;
    }


    public rentalAgreement getRentalbyId(int id){
        rentalAgreement rental=new rentalAgreement();
        String sql="SELECT * FROM rentalAgreement WHERE id=?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    rental.setId(resultSet.getInt("id"));
                    rental.setStartDato(resultSet.getDate("startDate"));
                    rental.setEndDate(resultSet.getDate("endDate"));
                    rental.setPrice(resultSet.getInt("price"));

                    String locationString = resultSet.getString("pickup");
                    rental.setLocation(Location.valueOf(locationString));
                    rental.setCustomerId(resultSet.getObject("costumer_id", Integer.class));

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rental;
    }

    public void deleteRental(int id){
        String sql="DELETE FROM rentalAgreement WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveRental (rentalAgreement rental){
        String sql="INSERT INTO rentalAgreement(startDate, endDate, price, pickup, costumer_id) VALUES (?,?,?,?,?)";

        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setDate(1,new java.sql.Date(rental.getStartDato().getTime()));
            statement.setDate(2, new java.sql.Date(rental.getEndDate().getTime()));
            statement.setInt(3,rental.getprice());
            statement.setString(4,rental.getLocation().toString());
            statement.setObject(5, rental.getCustomerId());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
