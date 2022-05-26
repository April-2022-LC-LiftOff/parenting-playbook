package org.launchcode.liftoffproject.models.dto;

import org.launchcode.liftoffproject.models.Comment;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.User;

import javax.validation.constraints.NotNull;

public class InterventionCommentDTO {

    @NotNull
    private Intervention intervention;

    @NotNull
    private Comment comment;

    @NotNull
    private User user;

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

