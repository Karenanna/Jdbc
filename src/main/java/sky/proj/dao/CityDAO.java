package sky.proj.dao;


import java.sql.SQLException;

public interface CityDAO {
    int findById(int id) throws SQLException;
}
