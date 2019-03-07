package ru.aponkin.service;

import ru.aponkin.dao.DBStore;
import ru.aponkin.dao.Store;
import ru.aponkin.model.Role;
import ru.aponkin.model.User;

import java.util.List;

/**
 * Class ValidateMemoryService.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 21.05.2018.
 */
public class ValidateMemoryService implements ValidateService {
    /**
     * Single instance ValidateMemoryService.
     */
    private final static ValidateMemoryService OUR_INSTANCE = new ValidateMemoryService();
    /**
     * Store users.
     */
    private final Store<User, Long> store = DBStore.getInstance();

    /**
     * Closed constructor.
     */
    private ValidateMemoryService() {
    }

    /**
     * Get instance ValidateMemoryService.
     * @return single instance.
     */
    public static ValidateService getInstance() {
        return OUR_INSTANCE;
    }

    /**
     * Validate and add user in store.
     * @param user to add.
     * @return true if successful otherwise false.
     */
    public boolean add(User user) {
        boolean result = true;
        for (User userCheckLoginAndEmail: this.findAll()) {
            if (userCheckLoginAndEmail.getLogin().equals(user.getLogin())
                    || userCheckLoginAndEmail.getEmail().equals(user.getEmail())) {
                result = false;
                break;
            }
        }
        if (result) {
            this.store.add(user);
        }
        return result;
    }

    /**
     * Check that store contains user and update him in store.
     * @param user to update.
     * @return true if successful otherwise false.
     */
    public boolean update(User user) {
        boolean result = false;
        if (this.findById(user.getId()) != null) {
            result = this.store.update(user);
        }
        return result;
    }

    /**
     * Check that the store contains user and delete him from store.
     * @param user to delete.
     * @return true if successful otherwise false.
     */
    public boolean delete(User user) {
        boolean result = false;
        if (this.findById(user.getId()) != null) {
            result = this.store.delete(user);
        }
        return result;
    }

    /**
     * Find all users.
     * @return list users.
     */
    public List<User> findAll() {
        return this.store.findAll();
    }

    /**
     * Find user by id.
     * @param id user.
     * @return true if successful otherwise false.
     */
    public User findById(Long id) {
        return this.store.findById(id);
    }

    /**
     * Find user by login and password.
     * @param login user.
     * @param password user.
     * @return user found .
     */
    public User findByLoginPassword(String login, String password) {
        User result = new User();
        if (!login.equals("") || !password.equals("")) {
            result = this.store.findByLoginPassword(login, password);
        }
        return result;
    }

    /**
     * Find all roles user.
     * @return list roles.
     */
    public List<Role> findAllRole() {
        return this.store.findAllRole();
    }

    /**
     * Get all country from database.
     * @return list country.
     */
    public List<String> getAllCountry() {
        return this.store.getAllCountry();
    }

    /**
     * Get all city by country from database.
     * @return list city.
     */
    public List<String> getAllCityByCountry(String country) {
        return this.store.getAllCityByCountry(country);
    }
}