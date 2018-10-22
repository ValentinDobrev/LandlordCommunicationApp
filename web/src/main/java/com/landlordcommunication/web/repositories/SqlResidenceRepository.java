package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SqlResidenceRepository implements ResidenceRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Residence> getResidenceByLandlord(int landlordId) {
        //TODO
        return null;
    }

    @Override
    public List<Residence> getResidenceByTenant(int tenantdId) {
        // TODO
        return null;
    }

    @Override
    public void updateResidence() {

    }

    @Override
    public Residence delete() {
        return null;
    }

    @Override
    public Residence create() {
        return null;
    }

    @Override
    public List<Residence> getAllResidences() {
        List<Residence> result;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Residence").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public List<Residence> getResidencesByUser(int userId) {
        User user = getById(userId);

        List<Residence> result = user.getResidences();

        return result;
    }

    private User getById(int id) {
        User result;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from User where userId = :id", User.class)
                    .setParameter("id", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return result;
    }
}
