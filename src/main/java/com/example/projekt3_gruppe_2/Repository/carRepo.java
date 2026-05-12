package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class carRepo {

    @Autowired
    DataSource dataSource;

    public ArrayList<Car> getAllCars(){
        ArrayList<Car> carList = new ArrayList<>();
        String sql="SELECT * FROM car";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement =connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setCartNumber(resultSet.getString("cartNumber"));
                car.setVin(resultSet.getString("vin"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColor(resultSet.getString("color"));

                String statusString=resultSet.getString("car_status");
                car.setStatus(Status.valueOf(statusString));

                carList.add(car);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public Car getCarbyId(int id){
        Car car = new Car();
        String sql ="SELECT * FROM car WHERE  id=?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    car.setId(resultSet.getInt("id"));
                    car.setCartNumber(resultSet.getString("cartNumber"));
                    car.setVin(resultSet.getString("vin"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setModel(resultSet.getString("model"));
                    car.setColor(resultSet.getString("color"));

                    String statusString=resultSet.getString("car_status");
                    car.setStatus(Status.valueOf(statusString));

                    int rentalAgreementId = resultSet.getInt("rentalAgreement_id");
                    if (!resultSet.wasNull()) {
                        car.setRentalAgreementId(rentalAgreementId);
                    }

                    int damageReportId = resultSet.getInt("damageReport_id");
                    if (!resultSet.wasNull()) {
                        car.setDamageReportId(damageReportId);
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return car;
    }

    public void deleteCar(int id){
        String sql="DELETE FROM car WHERE id=?";

        try(Connection connection=dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void saveCar (Car car){
        String sql="INSERT INTO car(cartNumber, vin, brand, model, color, car_status) VALUES (?,?,?,?,?,?)";

        try (Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setString(1,car.getCartNumber());
            statement.setString(2,car.getVin());
            statement.setString(3,car.getBrand());
            statement.setString(4,car.getModel());
            statement.setString(5,car.getColor());
            statement.setString(6,car.getStatus().toString());

            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
