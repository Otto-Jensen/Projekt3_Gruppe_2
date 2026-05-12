package com.example.projekt3_gruppe_2.Repository;

import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Model.Damage;
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
                car.setRentalAgreementId(resultSet.getObject("rentalAgreement_id", Integer.class));
                car.setDamageReportId(resultSet.getObject("damageReport_id", Integer.class));

                carList.add(car);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public Car getCarbyId(int id){
        Car car = null;
        String sql ="SELECT * FROM car WHERE  id=?";

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    car = new Car();
                    car.setId(resultSet.getInt("id"));
                    car.setCartNumber(resultSet.getString("cartNumber"));
                    car.setVin(resultSet.getString("vin"));
                    car.setBrand(resultSet.getString("brand"));
                    car.setModel(resultSet.getString("model"));
                    car.setColor(resultSet.getString("color"));

                    String statusString=resultSet.getString("car_status");
                    car.setStatus(Status.valueOf(statusString));
                    car.setRentalAgreementId(resultSet.getObject("rentalAgreement_id", Integer.class));
                    car.setDamageReportId(resultSet.getObject("damageReport_id", Integer.class));
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
        String sql="INSERT INTO car(cartNumber, vin, brand, model, color, car_status,rentalAgreement_id,damageReport_id) VALUES (?,?,?,?,?,?,?,?)";

        try (Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setString(1,car.getCartNumber());
            statement.setString(2,car.getVin());
            statement.setString(3,car.getBrand());
            statement.setString(4,car.getModel());
            statement.setString(5,car.getColor());
            statement.setString(6,car.getStatus().toString());
            statement.setNull(7, Types.INTEGER);
            statement.setNull(8, Types.INTEGER);

            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void editCar(Car car){
        String sql="UPDATE car SET car_status=?, rentalAgreement_id=?, damageReport_id=? WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){

            statement.setString(1,car.getStatus().toString());
            statement.setObject(2,car.getRentalAgreementId());
            statement.setObject(3,car.getDamageReportId());
            statement.setInt(4,car.getId());

            statement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
