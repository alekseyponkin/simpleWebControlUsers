package ru.aponkin.dao;

import ru.aponkin.model.Role;
import ru.aponkin.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Class MemoryStore.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 21.05.2018.
 */
public class MemoryStore implements Store<User, Long> {
    /**
     * Sing instance MemoryStore.
     */
    private final static MemoryStore OUR_INSTANCE = new MemoryStore();
    /**
     * Store for users.
     */
    private final Map<Long, User> store = new ConcurrentHashMap<>();
    /**
     * Initialise variable id;
     */
    private final AtomicLong id = new AtomicLong(0);

    /**
     * Closed constructor.
     */
    private MemoryStore() {
    }

    /**
     * Get instance MemoryStore.
     * @return single instance.
     */
    public static MemoryStore getInstance() {
        return OUR_INSTANCE;
    }

    /**
     * Add user in store.
     * @param user
     * @return long id adding user.
     */
    @Override
    public long add(User user) {
        user.setCreateDate(LocalDateTime.now());
        user.setId(this.id.incrementAndGet());
        store.put(user.getId(), user);
        return user.getId();
    }

    /**
     * Update user in store.
     * @param user
     * @return true if successful otherwise false.
     */
    @Override
    public boolean update(User user) {
        boolean result = false;
        user.setCreateDate(this.store.get(user.getId()).getCreateDate());
        if (this.store.put(user.getId(), user) == null) {
            result = true;
        }
        return result;
    }

    /**
     * Delete user from store.
     * @param user
     * @return true if successful otherwise false.
     */
    @Override
    public boolean delete(User user) {
        boolean result = false;
        if (this.store.remove(user.getId()) != null) {
            result = true;
        }
       return result;
    }

    /**
     * Find all user in store.
     * @return list users.
     */
    @Override
    public List<User> findAll() {
        return new ArrayList(this.store.values());
    }

    /**
     * Fine user by id.
     * @param id user.
     * @return found user by id, otherwise null.
     */
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