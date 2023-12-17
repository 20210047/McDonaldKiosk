package repository;

import db.DBManager;
import entity.Category;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private DBManager dbManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Category> categoryList;

    public List<Category> findAll() {
        categoryList = new ArrayList<>();
        dbManager = new DBManager();
        try {
            int id;
            String categoryName;
            connection = dbManager.getConnection();
            String query = "SELECT * FROM category;";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id = resultSet.getInt("id");
                categoryName = resultSet.getString("category_name");
                Category category = new Category(id, categoryName);
                categoryList.add(category);
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
        return categoryList;
    }
}
