package pl.wsb.fitnesstracker.user.api;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * User class - Represents User Entity (person) and provides basic operation over it
 */
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Create new user instance
     * @param firstName - First name of the user
     * @param lastName - Last name of the user
     * @param birthdate - User birthdate
     * @param email - User email address
     */
    public User(
            final String firstName,
            final String lastName,
            final LocalDate birthdate,
            final String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
    }

    /**
     * Returns user id
     * @return id
     */
    @Nullable
    public Long getId() {
        return id;
    }

    /**
     * Set user ID
     * @param id - new user id
     */
    public void setId(@Nullable Long id) {
        this.id = id;
    }

    /**
     * Get user first name
     * @return User First Name as String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set user first name
     * @param firstName - New user FirstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get user last name
     * @return User Last Name as String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set user last name
     * @param lastName - New user last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get user birth date
     * @return User birth date as LocalDate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Set new user birth date
     * @param birthdate - New user birth date
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Returns user email address
     * @return email as String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set new user email
     * @param email - New user Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

