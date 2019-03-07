package ru.aponkin.dao;

import ru.aponkin.model.Role;
import ru.aponkin.model.User;

import java.util.List;

/**
 * Interface ParserVacancies.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 20.05.2018.
 */
public interface Store<Entity, Key> {
    /**
     * Add Entity.
     *
     * @param entity for adding.
     * @return long id adding user.
     */
    long add(Entity entity);

    /**
     * Update value Entity
     *
     * @param entity for updating.
     * @return true if successful otherwise false.
     */
    boolean update(Entity entity);

    /**
     * Delete Entity.
     *
     * @param entity for deleting.
     * @return true if successful otherwise false.
     */
    boolean delete(Entity entity);

    /**
     * Find all Entity in store.
     *
     * @return list Entity.
     */
    List<Entity> findAll();

    /**
     * Fine Entity by Key.
     *
     * @param key Entity for finding.
     * @return found Entity by Key, otherwise null.
     */
    Entity findById(Key key);

    /**
     * Find user by login and password.
     *
     * @param login    user.
     * @param password user.
     * @return user found .
     */
    User findByLoginPassword(String login, String password);

    /**
     * Find all roles user.
     *
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