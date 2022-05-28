package org.launchcode.liftoffproject.models;


import javax.persistence.Entity;
import java.util.ArrayList;


@Entity
public class Quiz extends AbstractEntity {

    private ArrayList<Quiz> questions = new ArrayList<>();
    private ArrayList<Quiz> impulseControl = new ArrayList<>();
    private ArrayList<Quiz> emotionalControl = new ArrayList<>();
    private ArrayList<Quiz> flexibleThinking = new ArrayList<>();
    private ArrayList<Quiz> workingMemory = new ArrayList<>();
    private ArrayList<Quiz> selfMonitoring = new ArrayList<>();
    private ArrayList<Quiz> planningAndPrioritizing = new ArrayList<>();
    private ArrayList<Quiz> taskInitiation = new ArrayList<>();
    private ArrayList<Quiz> organization = new ArrayList<>();


    public Quiz(ArrayList<Quiz> questions, ArrayList<Quiz> impulseControl, ArrayList<Quiz> emotionalControl, ArrayList<Quiz> flexibleThinking,
                ArrayList<Quiz> workingMemory, ArrayList<Quiz> selfMonitoring, ArrayList<Quiz> planningAndPrioritizing, ArrayList<Quiz> taskInitiation,
                ArrayList<Quiz> organization) {
        this.questions = questions;
        this.impulseControl = impulseControl;
        this.emotionalControl = emotionalControl;
        this.flexibleThinking = flexibleThinking;
        this.workingMemory = workingMemory;
        this.selfMonitoring = selfMonitoring;
        this.planningAndPrioritizing = planningAndPrioritizing;
        this.taskInitiation = taskInitiation;
        this.organization = organization;
    }



    public Quiz() {}

    public ArrayList<Quiz> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Quiz> questions) {
        this.questions = questions;
    }

    public ArrayList<Quiz> getImpulseControl() {
        return impulseControl;
    }

    public void setImpulseControl(ArrayList<Quiz> impulseControl) {
        this.impulseControl = impulseControl;
    }

    public ArrayList<Quiz> getEmotionalControl() {
        return emotionalControl;
    }

    public void setEmotionalControl(ArrayList<Quiz> emotionalControl) {
        this.emotionalControl = emotionalControl;
    }

    public ArrayList<Quiz> getFlexibleThinking() {
        return flexibleThinking;
    }

    public void setFlexibleThinking(ArrayList<Quiz> flexibleThinking) {
        this.flexibleThinking = flexibleThinking;
    }

    public ArrayList<Quiz> getWorkingMemory() {
        return workingMemory;
    }

    public void setWorkingMemory(ArrayList<Quiz> workingMemory) {
        this.workingMemory = workingMemory;
    }

    public ArrayList<Quiz> getSelfMonitoring() {
        return selfMonitoring;
    }

    public void setSelfMonitoring(ArrayList<Quiz> selfMonitoring) {
        this.selfMonitoring = selfMonitoring;
    }

    public ArrayList<Quiz> getPlanningAndPrioritizing() {
        return planningAndPrioritizing;
    }

    public void setPlanningAndPrioritizing(ArrayList<Quiz> planningAndPrioritizing) {
        this.planningAndPrioritizing = planningAndPrioritizing;
    }

    public ArrayList<Quiz> getTaskInitiation() {
        return taskInitiation;
    }

    public void setTaskInitiation(ArrayList<Quiz> taskInitiation) {
        this.taskInitiation = taskInitiation;
    }

    public ArrayList<Quiz> getOrganization() {
        return organization;
    }

    public void setOrganization(ArrayList<Quiz> organization) {
        this.organization = organization;
    }
}
