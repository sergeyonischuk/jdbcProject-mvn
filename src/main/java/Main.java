import services.DatabaseQueryService;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.getProjectPrices();
    }
}
