package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();

        gridPane.setMinWidth(600);
        gridPane.setMinHeight(500);

        gridPane.setVgap(5);
        gridPane.setHgap(20);

        gridPane.setGridLinesVisible(true);

        Label taskLabel = new Label("Tasks will be here");
        taskLabel.setMinWidth(600);

        gridPane.getChildren().addAll(taskLabel);
        gridPane.setConstraints(taskLabel, 1, 1, 3, 1);


        Scene scene = new Scene(gridPane, 600, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TaskMaker");
        primaryStage.setResizable(false);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
