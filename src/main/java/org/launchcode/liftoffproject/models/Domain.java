package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Domain extends AbstractEntity{

    @Size(max = 50, message = "Domain must not exceed 2000 characters.")
    private String domain;

    @Size(max = 2000, message = "Description must not exceed 2000 characters.")
    private String description;

    private Boolean checked;

    @ManyToMany(mappedBy = "domains")
    private  List<Intervention> interventions = new ArrayList<>();

    public Domain(String domain, String description) {
        this.domain = domain;
        this.description = description;
        this.checked = false;
    }

    public Domain() {}

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }

    @Override
    public String toString() {
        return domain;
    }
}
