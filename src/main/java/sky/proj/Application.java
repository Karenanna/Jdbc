package sky.proj;

import sky.proj.dao.CityDAO;
import sky.proj.dao.CityDAOImpl;
import sky.proj.dao.EmployDAO;
import sky.proj.dao.EmployDAOImpl;
import sky.proj.models.Employ;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    private static CityDAO cityDAO = new CityDAOImpl();

    private static EmployDAO employDAO = new EmployDAOImpl();
    public static void main(String[] args) throws SQLException {

        employDAO.addNewEmploy("Bob", "Rey",25, 3);

        employDAO.refactorEmploy(6, "Boris", "Akunin", 60, 4);

        for (Employ employ : employDAO.allEmployees()) {

        }

    }

}
