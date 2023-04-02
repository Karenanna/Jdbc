package sky.proj.dao;

import sky.proj.connect.ApplicationConnection;
import sky.proj.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAOImpl implements CityDAO{
    private final ApplicationConnection appConnection = new ApplicationConnection();

    @Override
    public City findById(int id) throws SQLException {
        try (PreparedStatement statement =
                     appConnection.getPreparedStatement("SELECT * FROM city WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new City(resultSet.getString("name"));
        }
    }
}
