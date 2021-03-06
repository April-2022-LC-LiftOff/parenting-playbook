package org.launchcode.liftoffproject.models;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
public class Quiz extends AbstractEntity {

    String [] impulseControl;
    String [] emotionalControl;
    String [] flexibleThinking;
    String [] workingMemory;
    String [] selfMonitoring;
    String [] planningAndPrioritizing;
    String [] taskInitiation;
    String [] organization;

    public  Quiz (String [] impulseControl,
    String [] emotionalControl,
    String [] flexibleThinking,
    String [] workingMemory,
    String [] selfMonitoring,
    String [] planningAndPrioritizing,
    String [] taskInitiation,
    String [] organization) {

        this.impulseControl = impulseControl;
        this.emotionalControl = emotionalControl;
        this.flexibleThinking = flexibleThinking;
        this.workingMemory = workingMemory;
        this.selfMonitoring = selfMonitoring;
        this.planningAndPrioritizing = planningAndPrioritizing;
        this.taskInitiation = taskInitiation;
        this.organization = organization;
    }

    private ArrayList<Quiz> quizResults = new ArrayList<>();

    public Quiz() {}

    public String[] getImpulseControl() {
        return impulseControl;
    }

    public void setImpulseControl(String[] impulseControl) {
        this.impulseControl = impulseControl;
    }

    public String[] getEmotionalControl() {
        return emotionalControl;
    }

    public void setEmotionalControl(String[] emotionalControl) {
        this.emotionalControl = emotionalControl;
    }

    public String[] getFlexibleThinking() {
        return flexibleThinking;
    }

    public void setFlexibleThinking(String[] flexibleThinking) {
        this.flexibleThinking = flexibleThinking;
    }

    public String[] getWorkingMemory() {
        return workingMemory;
    }

    public void setWorkingMemory(String[] workingMemory) {
        this.workingMemory = workingMemory;
    }

    public String[] getSelfMonitoring() {
        return selfMonitoring;
    }

    public void setSelfMonitoring(String[] selfMonitoring) {
        this.selfMonitoring = selfMonitoring;
    }

    public String[] getPlanningAndPrioritizing() {
        return planningAndPrioritizing;
    }

    public void setPlanningAndPrioritizing(String[] planningAndPrioritizing) {
        this.planningAndPrioritizing = planningAndPrioritizing;
    }

    public String[] getTaskInitiation() {
        return taskInitiation;
    }

    public void setTaskInitiation(String[] taskInitiation) {
        this.taskInitiation = taskInitiation;
    }

    public String[] getOrganization() {
        return organization;
    }

    public void setOrganization(String[] organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "impulseControl=" + Arrays.toString(impulseControl) +
                ", emotionalControl=" + Arrays.toString(emotionalControl) +
                ", flexibleThinking=" + Arrays.toString(flexibleThinking) +
                ", workingMemory=" + Arrays.toString(workingMemory) +
                ", selfMonitoring=" + Arrays.toString(selfMonitoring) +
                ", planningAndPrioritizing=" + Arrays.toString(planningAndPrioritizing) +
                ", taskInitiation=" + Arrays.toString(taskInitiation) +
                ", organization=" + Arrays.toString(organization) +
                ", quizResults=" + quizResults +
                '}';
    }
}