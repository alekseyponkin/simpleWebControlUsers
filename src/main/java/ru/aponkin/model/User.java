package ru.aponkin.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class User.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 18.05.2018.
 */
public class User {
    /**
     * Id user.
     */
    private Long id = 0L;
    /**
     * Name user.
     */
    private String name;
    /**
     * Login user.
     */
    private String login;

    /**
     * Password user.
     */
    private String password;

    /**
     * Email user.
     */
    private String email;
    /**
     * Date create user.
     */
    private LocalDateTime createDate;
    /**
     * Role user.
     */
    private Role role;
    /**
     * Country user.
     */
    private String country;
    /**
     * City user
     */
    private String city;
    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructor User with name, login, email.
     * @param name user.
     * @param login user.
     * @param email user.
     * @param country user.
     * @param city user.
     */
    public User(String name, String login, String email, String country, String city) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(name, user.name)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(email, user.email)
                && Objects.equals(country, user.country)
                && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, email, country, city);
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", email='" + email + '\''
                + ", createDate=" + createDate
                + ", role=" + role
                + ", country='" + country + '\''
                + ", city='" + city + '\''
                + '}';
    }
}