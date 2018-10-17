package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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
            session.delete(userID);
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
            userToBeModified.setBudget(user.getBudget());

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getTenantsByResidence() {
        //TODO
        return null;
    }

    @Override
    public List<User> getLandlordsByResidence() {
        //TODO
        return null;
    }

    @Override
    public List<User> getAllLandlords() {
        //TODO
        return null;
    }
}
