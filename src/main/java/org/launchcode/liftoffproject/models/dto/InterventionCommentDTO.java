package org.launchcode.liftoffproject.models.dto;

import org.launchcode.liftoffproject.models.Comment;
import org.launchcode.liftoffproject.models.Intervention;

import javax.validation.constraints.NotNull;

public class InterventionCommentDTO {

    @NotNull
    private Intervention intervention;

    @NotNull
    private Comment comment;

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
}

