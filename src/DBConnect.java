import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    // Code database URL
    static final String DB_URL = "[REDACTED]";
    // Database credentials
    static final String USER = "[REDACTED]", PASS = "[REDACTED]";

    public Connection connect() throws SQLException {

        return DriverManager.getConnection(DB_URL, USER, PASS);

    }
}
