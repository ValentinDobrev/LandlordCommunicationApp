package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Rating;
import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlUserRepository implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUser(User user) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int userID) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();

            User userToBeDeleted = new User();
            userToBeDeleted.setUserId(userID);

            session.delete(userToBeDeleted);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modifyUser(int userId, User user) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            User userToBeModified = session.get(User.class, userId);

            userToBeModified.setFirstName(user.getFirstName());
            userToBeModified.setSurname(user.getSurname());
            userToBeModified.setEmail(user.getEmail());
            userToBeModified.setPassword(user.getPassword());
            userToBeModified.setBudget(user.getBudget());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getTenantsByResidenceId(int residenceId) {
        //TODO
        return null;
    }

    @Override
    public List<User> getLandlordsByResidenceId(int residenceId) {
        //TODO
        return null;
    }

    @Override
    public List<User> getAllLandlords() {
        List<User> result;
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from User where isTenant = false")
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return result;

    }

    @Override
    public List<Rating> getUserRatings(int userId) {
        //User user = getUserById(userId);
        List<Rating> result = null;

        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from Rating where takerId = :userId")
                    .setParameter("userId", userId)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        return result;
        //return user.getRatingsTaken();
    }

    private User getUserById(int id) {
        User result;

        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from User where userId = :id", User.class)
                    .setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public List<User> getUsersByResidence(int residenceId) {
        Residence residence = getResidenceById(residenceId);

        return residence.getUsers();
    }

    private Residence getResidenceById(int id) {
        Residence result;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Residence where residenceId = :id", Residence.class)
                    .setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;
    }
}
