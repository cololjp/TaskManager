package com.jpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView taskTable;

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

    }
}
