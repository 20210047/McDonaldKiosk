package repository;

import db.DBManager;
import entity.User;

import java.sql.*;

public class UserRepository {
    private DBManager dbManager;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public User findByUsername(String username) {
        int id;
        String _username;
        String _password;
        dbManager = new DBManager();
        String query = "SELECT * FROM member WHERE username=?";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                id = resultSet.getInt("id");
                _username = resultSet.getString("username");
                _password = resultSet.getString("password");
                return new User(id, _username, _password);
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

    public void save(User user) {
        dbManager = new DBManager();
        String query = "INSERT INTO member('username', 'password') VALUES (?, ?)";
        try {
            connection = dbManager.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "username");
            preparedStatement.setString(2, "password");
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
