package sky.proj.dao;

import sky.proj.models.Employ;

import java.sql.SQLException;
import java.util.List;

public interface EmployDAO {
    Employ findById(int id) throws SQLException;

    void addNewEmploy(String firstName, String lastName, int age, int cityId) throws SQLException;

    void refactorEmploy(int id, String firstName, String lastName, int age, int cityId) throws SQLException;

    List<Employ> allEmployees() throws SQLException;
}
