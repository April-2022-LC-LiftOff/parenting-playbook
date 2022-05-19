package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Tag extends AbstractEntity{

    @NotBlank
    @Size(max = 20, message = "Tag cannot exceed 20 characters.")
    private String tagName;

    @ManyToOne
    private Intervention intervention;

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Tag() {}

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    @Override
    public String toString() {
        return tagName;
    }
}
