package sky.proj.dao;


import sky.proj.models.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {
    City findById(int id) throws SQLException;

    City add(City city);

    City getById(Long id);

    List getAllCity();

    City updateCity(City city);

    void deleteCity(City city);

    void updateCity(City city, Integer cityId);
}
