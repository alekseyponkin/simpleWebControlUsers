package ru.aponkin.model;

/**
 * Class Role.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 21.06.2018.
 */
public class Role {
    /**
     * Id role.
     */
    Long id;
    /**
     * Name role.
     */
    String name;

    /**
     * Constructor Role with name role.
     * @param name role.
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Constructor Role with id and name role.
     * @param id role.
     * @param name role.
     */
    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}