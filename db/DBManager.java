package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    private Connection connection;
    private DBConfig config;

    public Statement getStatement() {
        try {
            connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void disconnect() {
        try{
            connection.close();
        } catch (SQLException e) {
            System.err.println("connection.close() 에러");
        }
    }

    public Connection getConnection() throws SQLException {
        connection = null;

        try {
            Class.forName(config.DRIVER);

            connection = DriverManager.getConnection(config.URL, config.USER, config.PW);

            //System.out.println("DB 연결 성공");
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.err.println("Connection 객체 생성 실패");
        }
        return connection;
    }
}
