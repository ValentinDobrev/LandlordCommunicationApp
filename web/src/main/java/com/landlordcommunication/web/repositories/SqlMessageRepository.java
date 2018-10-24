package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.Message;
import com.landlordcommunication.web.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;

public class SqlMessageRepository implements MessageRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createMessage(Message message) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(message);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteMessage(int messageId) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();

            Message messageToBeDeleted = new Message();
            messageToBeDeleted.setMessageId(messageId);

            session.delete(messageToBeDeleted);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Message> getAllMessagesByReceiverIdAndByResidenceId(int receiverId, int residenceId) {
        List<Message> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.createQuery("from Message where receiverId = :receiverId and residenceId = :residenceId ")
                    .setParameter("receiverId", receiverId)
                    .setParameter("residenceId", residenceId)
                    .list();
            session.getTransaction().commit();
        }
        return result;
    }

}
