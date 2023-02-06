package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection con = null;
    private static Database instance;

    static {
        String dbUrl = "jdbc:postgresql://localhost/company";
        String login = "postgres";
        String password = "3nyn56";
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static Database getInstance() throws SQLException {
        if (instance == null) {
            instance = new Database();
        } else if (instance.getConnection().isClosed()) {
            instance = new Database();
        }

        return instance;
    }
}
