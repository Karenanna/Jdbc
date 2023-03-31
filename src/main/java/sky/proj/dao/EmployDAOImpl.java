package sky.proj.dao;

import sky.proj.connect.ApplicationConnection;
import sky.proj.models.Employ;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployDAOImpl implements EmployDAO {
    private final ApplicationConnection appConnect = new ApplicationConnection();

    private final CityDAO cityDAO = new CityDAOImpl();


    @Override
    public Employ findById(int id) throws SQLException {
        try (PreparedStatement statement =
                     appConnect.getPreparedStatement("SELECT * FROM employ WHERE id = (?) ")) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new Employ(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"),
                    cityDAO.findById(resultSet.getInt("city_id")));

        }
    }

    @Override
    public void addNewEmploy(String firstName, String lastName, int age, int cityId) throws SQLException {
        try (PreparedStatement statement = appConnect.getPreparedStatement
                ("INSERT INTO employ (first_name, last_name, age, city_id) VALUES (?,?,?,?")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setInt(4, cityId);
            statement.executeUpdate();
        }
    }
    @Override
    public void refactorEmploy(int id, String firstName, String lastName, int age, int cityId) throws SQLException {
        try (PreparedStatement statement = appConnect.getPreparedStatement
                ("UPDATE employ SET first_name = ?, last_name = ?, age =?, city_id =? WHERE id = (?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setInt(4, cityId);
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }

    public void deleteEmployById(int id) throws SQLException {
        try (PreparedStatement statement = appConnect.getPreparedStatement("DELETE FROM employ WHERE id=(?)")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    @Override
    public List<Employ> allEmployees() throws SQLException {
        try (PreparedStatement statement =
                     appConnect.getPreparedStatement
                             ("SELECT * FROM employ")) {
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            List<Employ> employs = new ArrayList<>();

            while (resultSet.next()) {

                employs.add(new Employ(resultSet.getString("first_name"),
                        resultSet.getString("lasst_name"), resultSet.getInt("age"), cityDAO.findById
                        (resultSet.getInt("city_id"))));

            }
            return employs;
        }
    }
}
