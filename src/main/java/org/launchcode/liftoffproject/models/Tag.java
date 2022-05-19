package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Tag extends AbstractEntity{

    @NotBlank
    @Size(max = 20, message = "Tag cannot exceed 20 characters.")
    private String tagName;

    @ManyToMany(mappedBy = "tags")
    private List<Intervention> interventions;

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

    public List<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }

    @Override
    public String toString() {
        return tagName;
    }
}
