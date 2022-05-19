package org.launchcode.liftoffproject.models.dto;

import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.Tag;

import javax.validation.constraints.NotNull;

public class InterventionTagDTO {

    @NotNull
    private Intervention intervention;

    @NotNull
    private Tag tag;

    public InterventionTagDTO() {}

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
