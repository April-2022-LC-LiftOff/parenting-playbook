package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Comment extends AbstractEntity {

    @NotBlank(message = "Comment cannot be blank.")
    @Size(max = 1000, message = "Comment cannot exceed 1000 characters.")
    private String userInput;

    @ManyToOne
    private Intervention intervention;

    public Comment(String userInput) {
        this.userInput = userInput;
    }

    public Comment() {}

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    @Override
    public String toString() {
        return userInput;
    }
}
