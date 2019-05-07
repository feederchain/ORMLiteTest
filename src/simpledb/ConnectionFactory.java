package simpledb;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author gregbeauregard
 */
public class ConnectionFactory {
    
    private static final Parser PARSER = new Parser();

    public static Connection getConnection() {
        try {
            Class.forName(PARSER.parseDriver());
            return DriverManager.getConnection(PARSER.parseUrl(), PARSER.parseUser(), PARSER.parsePassword());
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static ConnectionSource getConnectionSource() throws IOException {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource(PARSER.parseUrl(), PARSER.parseUser(), PARSER.parsePassword());

            return connectionSource;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } finally {
            if (connectionSource != null) {
                connectionSource.close();
            }
        }
    }
}
