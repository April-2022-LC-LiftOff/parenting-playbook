package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Domain extends AbstractEntity{

    private String domain;

    private String description;

    @ManyToMany(mappedBy = "domains")
    private  List<Intervention> interventions = new ArrayList<>();

    public Domain(String domain, String description) {
        this.domain = domain;
        this.description = description;
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

    public List<Intervention> getInterventions() {
        return interventions;
    }

    public void setInterventions(List<Intervention> interventions) {
        this.interventions = interventions;
    }
}
