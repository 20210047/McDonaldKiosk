package repository;

import db.DBManager;
import entity.Category;
import entity.Order;
import entity.OrderProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderProductRepository {
    private DBManager dbManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    private List<OrderProduct> orderProductList;

    public String[] findColumnName() {
        String[] cols;
        try{
            String query = "SELECT * FROM category;";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            resultSetMetaData = resultSet.getMetaData();
            int col = resultSetMetaData.getColumnCount();
            cols = new String[col];
            if(resultSet.next()) {
                for(int i=0; i<col; i++) {
                    cols[i] = resultSetMetaData.getColumnName(i);
                }
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
        return cols;
    }

    public List<OrderProduct> findAll() {
        orderProductList = new ArrayList<>();
        dbManager = new DBManager();
        try {
            int id;
            int productId;
            int orderId;
            int quantity;
            int price;
            connection = dbManager.getConnection();
            String query = "SELECT * FROM category;";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                productId = resultSet.getInt("product_id");
                orderId = resultSet.getInt("order_id");
                quantity = resultSet.getInt("quantity");
                price = resultSet.getInt("price");
                OrderProduct orderProduct = new OrderProduct(id, productId, orderId, quantity, price);
                orderProductList.add(orderProduct);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

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
        return orderProductList;
    }

    public OrderProduct findById(int id) {
        int _id;
        int productId;
        int orderId;
        int quantity;
        int price;
        OrderProduct orderProduct;
        dbManager = new DBManager();
        String query = "SELECT * FROM orderproduct WHERE id=?";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                _id = resultSet.getInt("id");
                productId = resultSet.getInt("product_id");
                orderId = resultSet.getInt("order_id");
                quantity = resultSet.getInt("quantity");
                price = resultSet.getInt("price");
                orderProduct = new OrderProduct(_id, productId, orderId, quantity, price);
                return orderProduct;
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

    public void save(OrderProduct orderProduct) {
        dbManager = new DBManager();
        String query = "INSERT INTO ('product_id', 'order_id', 'quantity', 'price') VALUES (?, ?, ?, ?)";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderProduct.getOrderId());
            preparedStatement.setInt(2, orderProduct.getOrderId());
            preparedStatement.setInt(3, orderProduct.getQuantity());
            preparedStatement.setInt(4, orderProduct.getPrice());
            resultSet = preparedStatement.executeQuery();
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
