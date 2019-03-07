package ru.aponkin.model;

import java.util.Objects;

/**
 * Class UserTable.
 *
 * @author Ponkin Aleksey
 * @version 1.0.0
 * @since 05.11.2018.
 */
public class UserTable {
    /**
     * Fist name user.
     */
    private String firstName;
    /**
     * Last name user.
     */
    private String lastName;
    /**
     * Sex user.
     */
    private String sex;
    /**
     * Description.
     */
    String description;

    /**
     * Constructor UserTable.
     */
    public UserTable() {
    }

    /**
     * Constructor UserTable witch parameters.
     * @param firstName first name User.
     * @param lastName last name User.
     * @param sex sex User.
     * @param description description about User.
     */
    public UserTable(String firstName, String lastName, String sex, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.description = description;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserTable{"
                + "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", sex='" + sex + '\''
                + ", description='" + description + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserTable userTable = (UserTable) o;
        return Objects.equals(firstName, userTable.firstName)
                && Objects.equals(lastName, userTable.lastName)
                && Objects.equals(sex, userTable.sex)
                && Objects.equals(description, userTable.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, sex, description);
    }
}
