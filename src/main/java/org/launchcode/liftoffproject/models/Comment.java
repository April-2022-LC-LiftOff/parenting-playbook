package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends AbstractEntity {

    private String commentText;

    @ManyToOne
    private Intervention intervention;

    public Comment() {}

    public Comment(String commentText, Intervention intervention) {
        this.commentText = commentText;
        this.intervention = intervention;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    @Override
    public String toString() {
        return commentText;
    }
}
