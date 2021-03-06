package com.landlordcommunication.web.repositories.user;

import com.landlordcommunication.web.models.*;
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
    public User getUserById(int id) {
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
    public List<User> getAllUsers() {
        List<User> result;

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            result = session.createQuery("from User").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        return result;
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
    public List<User> getAllTenants() {
        List<User> result;
        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = session.createQuery("from User where isTenant = true")
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
        List<Rating> result;

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
    }

    @Override
    public UserRating getRatingById(int userId) {
        Double result;

        try (
                Session session = sessionFactory.openSession()
        ) {
            session.beginTransaction();
            result = (Double) session.createQuery("select avg(rating) from Rating where takerId = :userId")
                    .setParameter("userId", userId)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        String value = String.valueOf(result);
        if (value.length() > 4) {
            value = value.substring(0, 4);
            result = Double.valueOf(value);
        }

        return new UserRating(userId, result);
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

    @Override
    public void payRentFromTenantToLandlord(int tenantId, int landlordId, int residenceId) {

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            User tenant = session.get(User.class, tenantId);
            User landlord = session.get(User.class, landlordId);
            Residence residence = getResidenceById(residenceId);

            double rent = residence.getRent();
            double tenantBudget = tenant.getBudget();
            double landlordBudget = landlord.getBudget();

            tenant.setBudget(tenantBudget - rent);
            landlord.setBudget(landlordBudget + rent);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByEmail(LoginInfo loginInfo) {

        User result;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from User where email = :email", User.class)
                    .setParameter("email", loginInfo.getLoginName()).uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }
}
