package ru.aponkin.service;

import ru.aponkin.model.Role;
import ru.aponkin.model.User;

import java.util.List;

public interface ValidateService {

    /**
     * Validate and add user in store.
     * @param user to add.
     * @return true if successful otherwise false.
     */
    boolean add(User user);

    /**
     * Check that store contains user and update him in store.
     * @param user to update.
     * @return true if successful otherwise false.
     */
    boolean update(User user);

    /**
     * Check that the store contains user and delete him from store.
     * @param user to delete.
     * @return true if successful otherwise false.
     */
    boolean delete(User user);

    /**
     * Find all users.
     * @return list users.
     */
    List<User> findAll();

    /**
     * Find user by id.
     * @param id user.
     * @return true if successful otherwise false.
     */
    User findById(Long id);

    /**
     * Find user by login and password.
     * @param login user.
     * @param password user.
     * @return user found .
     */
    User findByLoginPassword(String login, String password);

    /**
     * Find all roles user.
     * @return list roles.
     */
    List<Role> findAllRole();

    /**
     * Get all country from database.
     * @return list country.
     */
    List<String> getAllCountry();

    /**
     * Get all city by country from database.
     * @return list city.
     */
    List<String> getAllCityByCountry(String country);
}