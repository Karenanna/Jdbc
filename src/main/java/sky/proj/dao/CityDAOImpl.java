package sky.proj.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sky.proj.connect.ApplicationConnection;
import sky.proj.hibernate.HibernateSessionsFactoryUtil;
import sky.proj.models.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private final ApplicationConnection appConnection = new ApplicationConnection();

    @Override
    public City findById(int id) throws SQLException {
        try (PreparedStatement statement =
                     appConnection.getPreparedStatement("SELECT * FROM city WHERE id = (?)")) {
            statement.setInt(1, id);
            statement.executeQuery();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return new City(resultSet.getString("name"));
        }
    }

    @Override
    public City add(City city) {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City getById(Long id) {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List getAllCity() {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();

        }
    }

    @Override
    public City updateCity(City city) {
        City updated;
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            updated = (City) session.merge(city);
            transaction.commit();
        }

        return updated;

    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionsFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.delete(city);
            transaction.commit();
        }
    }

    @Override
    public void updateCity(City city, Integer cityId) {

    }
}

