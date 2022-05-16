package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends AbstractEntity {

    private String comment;

    @ManyToOne
    private Intervention intervention;

    public Comment() {}

    public Comment(String comment, Intervention intervention) {
        this.comment = comment;
        this.intervention = intervention;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    @Override
    public String toString() {
        return comment;
    }
}
