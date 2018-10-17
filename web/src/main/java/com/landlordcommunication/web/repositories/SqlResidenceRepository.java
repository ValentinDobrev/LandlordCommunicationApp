package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.repositories.ResidenceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SqlResidenceRepository implements ResidenceRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Residence getResidenceByLandlord(int landlordId) {
        Residence residence;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            residence = session.createQuery("from Residence where landlordId = :LandlordId")
                    .setParameter("LandlordId", landlordId).

          //  session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return residence;

    }

    @Override
    public Residence getResidenceByTenant() {
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
        return null;
    }
}
