package sky.proj;

import sky.proj.dao.EmployDAO;
import sky.proj.dao.EmployDAOImpl;
import sky.proj.models.Employ;

public class Application {
    public static void main(String[] args, Employ employ) {

        EmployDAO employDAO = new EmployDAOImpl();
        employDAO.getAllEmploy().forEach(System.out::println);
        Integer employId = employDAO.add(employ);
        System.out.println(employDAO.getAllEmploy());
        System.out.println();
        employDAO.updateEmploy(employ, employId);
        employDAO.deleteEmploy(employDAO.getById(employId));


        System.out.println(employDAO.getById(3));
    }
}

