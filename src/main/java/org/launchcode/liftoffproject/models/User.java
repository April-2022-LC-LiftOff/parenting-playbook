package org.launchcode.liftoffproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity{
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(min =3, max = 50)
//    private String username;
//
//    @NotNull
//    private String pwHash;
//
//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//    public User(String username, String password) {
//        this.username = username;
//        this.pwHash = encoder.encode(password);
//    }
//    public User(){}
//
//    public String getUsername() {
//        return username;
//    }
//
//    public boolean isMatchingPassword(String password) {
//
//        return encoder.matches(password, pwHash);
//    }
//
//

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    @OneToMany(mappedBy = "user")
//    private final List<Review> reviews = new ArrayList<>();

    public User(){}

    public User(String firstName, String lastName, String email, String username, String password, String verifyPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.pwHash = encoder.encode(verifyPassword);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {

        return encoder.matches(password, pwHash);
    }


}
