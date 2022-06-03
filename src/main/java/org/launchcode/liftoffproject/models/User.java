package org.launchcode.liftoffproject.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{
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

    @OneToMany(mappedBy = "user")
    private final List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Intervention> intervention = new ArrayList<>();

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

    public List<Comment> getComments() {
        return comments;
    }

    public boolean isMatchingPassword(String password) {

        return encoder.matches(password, pwHash);
    }


    public List<Intervention> getIntervention() {
        return intervention;
    }

    public void setInterventions(List<Intervention> intervention) {
        this.intervention = intervention;
    }

}
