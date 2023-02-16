package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static Connection con = null;
    private static DataSource instance;

    static {
        String dbUrl = "jdbc:postgresql://localhost/company";
        String login = "postgres";
        String password = "3nyn56";
        try {
            con = DriverManager.getConnection(dbUrl, login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static DataSource getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataSource();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataSource();
        }

        return instance;
    }
}
