package services;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        String dbPath = "src/main/resources/init_db.sql";

        Connection connection = Database.getConnection();
        try {
            Statement statement = connection.createStatement();
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader(dbPath));
            sr.runScript(reader);
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
