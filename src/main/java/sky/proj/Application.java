package sky.proj;

import sky.proj.dao.CityDAO;
import sky.proj.dao.CityDAOImpl;
import sky.proj.dao.EmployDAO;
import sky.proj.dao.EmployDAOImpl;
import sky.proj.models.City;
import sky.proj.models.Employ;

import java.sql.SQLException;

public class Application {
    private static CityDAO cityDAO = new CityDAOImpl();

    private static EmployDAO employDAO = new EmployDAOImpl();

    static void addCity(City city) {
        cityDAO.add(city);
    }

    static City findCityById(Long id) {
        return cityDAO.findById(id);
    }

    static void updateCity(City city) {
        cityDAO.updateCity(city);
    }

    static void deleteCity(City city) {
        cityDAO.deleteCity(city);
    }

    static void addEmploy(Employ employ) {
        employDAO.add(employ);
    }

    static Employ findEmployById(Long id) {
        return employDAO.getById(id);
    }

    static void updateEmploy(Employ employ) {
        employDAO.updateEmploy(employ, employ.getId());
    }

    static void deleteEmploy(Employ employ) {
        employDAO.deleteEmploy(employ);
    }

    static void printEmploy() {
        for (Employ employ : employDAO.getAllEmploy()) {
            System.out.println(employ);
        }
    }

    public static void main(String[] args) throws SQLException {
    }
}





