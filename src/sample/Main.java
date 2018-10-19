package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.web.HTMLEditor;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

    private Controller control;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        control = loader.getController();

        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 400, 800));
        primaryStage.show();
    }

    @Override
    public void stop() {
        control.save();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
