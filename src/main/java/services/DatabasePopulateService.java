package services;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String dbPath = "src/main/resources/populate_db.sql";

        Connection connection = Database.getConnection();
        try {
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader(dbPath));
            sr.runScript(reader);
            connection.close();
        } catch (SQLException | FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
