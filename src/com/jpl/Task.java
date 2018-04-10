package com.jpl;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {

    private StringProperty description = new SimpleStringProperty();
    private SimpleStringProperty priority = new SimpleStringProperty(this, "priority");
    private SimpleBooleanProperty completedStatus = new SimpleBooleanProperty(this, "completedStatus");

    public Task() {
    }

    public Task(String description, String priority, boolean completedStatus) {
        this.description.set(description);
        this.priority.set(priority);
        this.completedStatus.set(completedStatus);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getPriority() {
        return priority.get();
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    public boolean isCompletedStatus() {
        return completedStatus.get();
    }

    public void setCompletedStatus(boolean completedStatus) {
        this.completedStatus.set(completedStatus);
    }

    public BooleanProperty completedStatusProperty() {
        return completedStatus;
    }

}
