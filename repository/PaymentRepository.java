package repository;

import db.DBManager;
import entity.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    private DBManager dbManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Payment findById(int id) {
        int _id;
        String paymentName;
        Payment payment;
        dbManager = new DBManager();
        String query = "SELECT * FROM payment WHERE id=?";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                _id = resultSet.getInt("id");
                paymentName = resultSet.getString("payment_name");
                payment = new Payment(_id, paymentName);
                return payment;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Payment> findAll() {
        List<Payment> paymentList = new ArrayList<>();
        dbManager = new DBManager();
        try {
            int id;
            String paymentName;
            connection = dbManager.getConnection();
            String query = "SELECT * FROM payment;";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                paymentName = resultSet.getString("payment_name");
                Payment payment = new Payment(id, paymentName);
                paymentList.add(payment);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

            return paymentList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
