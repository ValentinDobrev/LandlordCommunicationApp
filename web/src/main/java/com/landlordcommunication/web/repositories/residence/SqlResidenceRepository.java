package com.landlordcommunication.web.repositories.residence;

import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.repositories.residence.ResidenceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class SqlResidenceRepository implements ResidenceRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Residence> getResidencesByUser(int userId) {

        User user = getUserById(userId);

        return user.getResidences();
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
    public Residence changeResidenceDates(int residenceId) {
        Residence residence;

        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            residence = session.get(Residence.class, residenceId);

            Date dueDate = residence.getDueDate();
            Date notificationDate = residence.getNotificationDate();

            residence.setDueDate(addOneMonth(dueDate));
            residence.setNotificationDate(addOneMonth(notificationDate));

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return  residence;
    }

    public static Date addOneMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        return cal.getTime();
    }

}
