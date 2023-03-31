package sky.proj.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationConnection {

    private Connection getConnection() throws SQLException {

        String URL = "jdbc:postgresql://localhost:5432/webapp";
        String USERNAME = "postgres";
        String PASSWORD = "701101";
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public PreparedStatement getPreparedStatement(String sql)
            throws SQLException {
        return getConnection().prepareStatement(sql);
    }

}
