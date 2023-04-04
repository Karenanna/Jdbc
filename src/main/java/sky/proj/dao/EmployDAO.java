package sky.proj.dao;

import sky.proj.models.Employ;

import java.sql.SQLException;
import java.util.List;

public interface EmployDAO {
    Integer add(Employ employ);

    Employ getById(int id);

    List<Employ> getAllEmploy();

    void updateEmploy(Employ employ, int id);

    void deleteEmploy(Employ employ);
}

