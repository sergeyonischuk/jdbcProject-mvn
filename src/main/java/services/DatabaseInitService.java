package services;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

public class DatabaseInitService {

    public static void main(String[] args) {
        String dbPath = "src/main/resources/init_db.sql";

        Connection connection = Database.getConnection();
        try {
            ScriptRunner sr = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader(dbPath));
            sr.runScript(reader);
        } catch (FileNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
