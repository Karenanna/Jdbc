package sky.proj.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sky.proj.connect.ApplicationConnection;
import sky.proj.hibernate.HibernateSessionsFactoryUtil;
import sky.proj.models.Employ;

import java.util.List;

public class EmployDAOImpl implements EmployDAO {
    private final ApplicationConnection appConnect = new ApplicationConnection();

    private final CityDAO cityDAO = new CityDAOImpl();


    @Override
    public Integer add(Employ employ) {
        Integer id;
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Integer) session.save(employ);
            transaction.commit();

        }
        return id;
    }

    @Override
    public Employ getById(Long id) {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employ.class, id);
        }
    }


    @Override
    public List<Employ> getAllEmploy() {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employ").list();
        }
    }

    @Override
    public void updateEmploy(Employ employ, int id) {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            employ.setId(id);
            session.update(employ);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmploy(Employ employ) {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(employ);
            transaction.commit();
        }
    }
}


