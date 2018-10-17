package com.landlordcommunication.web.services;

import com.landlordcommunication.web.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandlordTenantServiceImpl implements LandlordTenantService {

    private final BaseRepository repository;

    @Autowired
    public LandlordTenantServiceImpl(BaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void create(User user) {
        repository.create(user);
    }

    @Override
    public void update(int id, User user) {
        repository.update(id, user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}
