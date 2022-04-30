package org.launchcode.liftoffproject.models.dto;

import org.launchcode.liftoffproject.models.Domain;
import org.launchcode.liftoffproject.models.Intervention;

import javax.validation.constraints.NotNull;

public class InterventionDomainDTO {

    @NotNull
    private Intervention intervention;

    @NotNull
    private Domain domain;

    public InterventionDomainDTO() {}

    public Intervention getIntervention() {
        return intervention;
    }

    public void setIntervention(Intervention intervention) {
        this.intervention = intervention;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
