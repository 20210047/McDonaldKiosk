package repository;

import db.DBManager;
import entity.Order;

import java.sql.*;
import java.util.List;

public class OrderRepository {
    private DBManager dbManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Order> orderList;

    public Order findById(int id) {
        int memberId;
        Timestamp orderDate;
        int paymentId;
        Order order;
        dbManager = new DBManager();
        String query = "SELECT * FROM order_tbl WHERE id=?";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                memberId = resultSet.getInt("member_id");
                orderDate = resultSet.getTimestamp("created_at");
                paymentId = resultSet.getInt("payment_id");
                order = new Order(memberId, orderDate, paymentId);
                return order;
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

    public List<Order> findAll() {

        return orderList;
    }

    public void save(Order order) {
        dbManager = new DBManager();
        String query = "INSERT INTO `order_tbl`(`member_id`, `created_at`, `payment_id`) VALUES (?, ?, ?);";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, order.getMemberId());
            preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setInt(3, order.getPaymentId());
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}