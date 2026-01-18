package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Соединение закрыто");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Неудалось загрузить класс драйвера");
        }
        return connection;
    }// реализуйте настройку соеденения с БД
}
