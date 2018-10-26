package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller control;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        control = loader.getController();

        primaryStage.setTitle("To Do List");
        primaryStage.setScene(new Scene(root, 400, 600));

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
