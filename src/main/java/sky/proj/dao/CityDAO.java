package sky.proj.dao;

import sky.proj.models.City;

import java.sql.SQLException;

public interface CityDAO {
    City findById(int id) throws SQLException;
}
