package com.jpl;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private final Task currentTask = new Task();

    private final ObservableList<Task> tasks = FXCollections.observableArrayList();

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, String> descriptionColumn;

    @FXML
    private TableColumn<Task, String> priorityColumn;

    @FXML
    private TableColumn<Task, Boolean> statusColumn;

    @FXML
    private TextField taskDescriptionField;

    @FXML
    private ComboBox<String> prioritiesBox;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private CheckBox completedCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        prioritiesBox.getItems().addAll("High", "Medium", "Low");

        prioritiesBox.valueProperty().bindBidirectional(currentTask.priorityProperty());
        taskDescriptionField.textProperty().bindBidirectional(currentTask.descriptionProperty());

        taskTable.setItems(tasks);
        taskTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Task> observable, Task oldValue, Task newValue) -> setCurrentTask(newValue));

        descriptionColumn.setCellValueFactory(rowData -> rowData.getValue().descriptionProperty());
        priorityColumn.setCellValueFactory(rowData -> rowData.getValue().priorityProperty());
        statusColumn.setCellValueFactory(rowData -> rowData.getValue().completedStatusProperty());

        StringBinding addButtonTextBinding = new StringBinding() {
            @Override
            protected String computeValue() {
                {
                    super.bind(currentTask.descriptionProperty());
                }

                if (currentTask.getDescription() != null) {
                    return "Update";
                }
                return "Add";
            }
        };

        addButton.textProperty().bind(addButtonTextBinding);
        addButton.disableProperty().bind(Bindings.greaterThan(3, currentTask.descriptionProperty().length()));

        // This is just for testing
        tasks.addAll(new Task("Complete the Task Manager Application", "High", false),
                     new Task());

    }

    private void setCurrentTask(Task selectedTask) {
        if (selectedTask != null) {
            currentTask.setDescription(selectedTask.getDescription());
            currentTask.setPriority(selectedTask.getPriority());
            currentTask.setCompletedStatus(selectedTask.isCompletedStatus());
        } else {
            currentTask.setDescription("");
            currentTask.setPriority("");
            currentTask.setCompletedStatus(false);
        }
    }
}
