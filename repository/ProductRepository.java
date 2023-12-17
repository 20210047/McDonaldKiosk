package repository;

import db.DBManager;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private DBManager dbManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private List<Product> productList;

    public Product findById(int id) {
        dbManager = new DBManager();
        int _id;
        String productName;
        int price;
        int category;
        try {
            connection = dbManager.getConnection();
            String query = "SELECT * FROM product WHERE id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                _id = resultSet.getInt("id");
                productName = resultSet.getString("product_name");
                price = resultSet.getInt("price");
                category = resultSet.getInt("category");
                return new Product(_id, productName, price, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Product> findAll() {
        productList = new ArrayList<>();
        dbManager = new DBManager();
        try {
            int id;
            String productName;
            int price;
            int category;
            connection = dbManager.getConnection();
            String query = "SELECT * FROM product;";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                productName = resultSet.getString("product_name");
                price = resultSet.getInt("price");
                category = resultSet.getInt("category");
                Product product = new Product(id, productName, price, category);
                productList.add(product);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public List<Product> findAllByCategory(int value) {
        productList = new ArrayList<>();
        dbManager = new DBManager();
        String query = "SELECT * FROM product WHERE category=?;";
        try {
            int id;
            String productName;
            int price;
            int category;

            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, value);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                productName = resultSet.getString("product_name");
                price = resultSet.getInt("price");
                category = resultSet.getInt("category");
                Product product = new Product(id, productName, price, category);
                productList.add(product);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public void save(Product product) {
        dbManager = new DBManager();
        String query = "INSERT INTO product(product_name, price, category) VALUES (?, ?, ?)";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getCategory());
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
