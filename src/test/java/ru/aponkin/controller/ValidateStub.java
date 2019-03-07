package ru.aponkin.controller;

import ru.aponkin.model.Role;
import ru.aponkin.model.User;
import ru.aponkin.service.ValidateService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class ValidateStub.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 21.10.2018.
 */
public class ValidateStub implements ValidateService {

    /**
     * Store for Users.
     */
    private final Map<Long, User> store = new HashMap<>();
    /**
     * Variable for calculate id Users.
     */
    private long ids = 0;

    @Override
    public boolean add(User user) {
        user.setId(this.ids++);
        boolean result = true;
        if (this.store.putIfAbsent(user.getId(), user) != null) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        if (this.store.computeIfPresent(user.getId(), (k, v) -> v = user) != null) {
           result = true;
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        boolean result = false;
        if (this.store.remove(user.getId()) != null) {
            result = true;
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(this.store.values());
    }

    @Override
    public User findById(Long id) {
        return this.store.get(id);
    }

    @Override
    public User findByLoginPassword(String login, String password) {
        return null;
    }

    @Override
    public List<Role> findAllRole() {
        return null;
    }

    @Override
    public List<String> getAllCountry() {
        return null;
    }

    @Override
    public List<String> getAllCityByCountry(String country) {
        return null;
    }
}