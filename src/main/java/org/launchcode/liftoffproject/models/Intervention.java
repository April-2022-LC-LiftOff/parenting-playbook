package org.launchcode.liftoffproject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Intervention extends AbstractEntity{

    @NotBlank(message = "Name cannot be blank.")
    @Size(min = 5, max = 255, message = "Name must be longer than 5 characters and not exceed 255 characters.")
    private String name;

    @NotBlank(message = "Action cannot be blank.")
    @Size(min = 20, max = 2000, message = "Action must be longer than 20 characters and not exceed 2000 characters.")
    private String action;

    @NotBlank(message = "Expected Response cannot be blank.")
    @Size(min = 20, max = 2000, message = "Expected Response must be longer than 20 characters and not exceed 2000 characters.")
    private String expectedResponse;

    @Size(max = 2000, message = "Reference must be longer than 20 characters and not exceed 2000 characters.")
    private String reference;

    @Size(max = 2000, message = "If It Fails must be longer than 20 characters and not exceed 2000 characters.")
    private String ifItFails;

    @ManyToMany
    private List<Domain> domains = new ArrayList<>();

    @OneToMany
    private List<Tag> tags = new ArrayList<>();

    public Intervention(String name, String action, String expectedResponse, String reference, String ifItFails) {
        this.name = name;
        this.action = action;
        this.expectedResponse = expectedResponse;
        this.reference = reference;
        this.ifItFails = ifItFails;
    }

    public Intervention() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getIfItFails() {
        return ifItFails;
    }

    public void setIfItFails(String ifItFails) {
        this.ifItFails = ifItFails;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    @Override
    public String toString() {
        return name;
    }

}
