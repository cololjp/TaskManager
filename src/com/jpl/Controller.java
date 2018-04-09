package com.jpl;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    protected ComboBox<String> prioritiesBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        prioritiesBox.getItems().addAll("High", "Medium", "Low");
    }
}
