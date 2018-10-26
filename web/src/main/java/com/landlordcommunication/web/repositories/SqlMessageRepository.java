package com.landlordcommunication.web.repositories;
import com.landlordcommunication.web.models.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
        List<Message> result;
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