package com.landlordcommunication.web.repositories;

import com.landlordcommunication.web.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySqlRepository implements BaseRepository {

    @Override
    public List<User> getAll() {
        // TODO
        return null;
    }

    @Override
    public User getById(int id) {
        // TODO
        return null;
    }

    @Override
    public void create(User user) {
        // TODO
    }

    @Override
    public void update(int id, User user) {
        // TODO
    }

    @Override
    public void delete(int id) {
        // TODO
    }
}
