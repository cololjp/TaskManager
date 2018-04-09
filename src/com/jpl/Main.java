package com.jpl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = FXMLLoader.load(getClass().getResource("MainUI.fxml"));

        Scene scene = new Scene(gridPane, 600, 500);

        primaryStage.setTitle("Task Manager");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
