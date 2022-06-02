package org.launchcode.liftoffproject.models;

import javax.persistence.*;
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

    @ManyToMany
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "intervention")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    public Intervention(String name, String action, String expectedResponse, String reference, String ifItFails, User user) {
        this.name = name;
        this.action = action;
        this.expectedResponse = expectedResponse;
        this.reference = reference;
        this.ifItFails = ifItFails;
        this.user = user;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return name;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) { this.user = user;
    }
}
