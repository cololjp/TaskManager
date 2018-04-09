package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();

        gridPane.setMinWidth(600);
        gridPane.setMinHeight(500);

        gridPane.setVgap(5);
        gridPane.setHgap(10);

        //gridPane.setGridLinesVisible(true);

        TextField taskField = new TextField();
        taskField.setPromptText("Task name");
        taskField.setMinWidth(300);
        taskField.setFocusTraversable(false);  // Make the field unselected to see the prompt text
        GridPane.setConstraints(taskField, 1, 2);

        ComboBox<String> prioritiesBox = new ComboBox<String>();
        prioritiesBox.getItems().addAll("High", "Medium", "Low");
        prioritiesBox.setPromptText("Task Priority");
        GridPane.setConstraints(prioritiesBox, 2, 2);

        Button addButton = new Button("Add");
        addButton.setMinWidth(50);
        addButton.setAlignment(Pos.CENTER);
        GridPane.setConstraints(addButton, 3, 2);

        Button removeButton = new Button("Remove");
        removeButton.setMinWidth(60);
        GridPane.setConstraints(removeButton, 3, 3);

        TableView taskTableView = new TableView();
        taskTableView.setMinWidth(550);
        GridPane.setConstraints(taskTableView, 1, 1, 3, 1);

        TableColumn descriptionColumn = new TableColumn("Description");
        descriptionColumn.setMinWidth(300);
        TableColumn priorityColumn = new TableColumn("Priority");
        TableColumn statusColumn = new TableColumn("Progress Status");
        statusColumn.setMinWidth(140);
        taskTableView.getColumns().addAll(descriptionColumn, priorityColumn, statusColumn);

        gridPane.getChildren().addAll(taskField, prioritiesBox, addButton, removeButton, taskTableView);

        Scene scene = new Scene(gridPane, 560, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TaskMaker");
        primaryStage.setResizable(false);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
