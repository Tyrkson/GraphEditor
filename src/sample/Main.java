package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void stop() throws IOException {
        System.out.println("Stage is closing");
        FileManager.saveGraph("Graph.txt", "Edges.txt");
        FileManager.saveCoordinates("Coordinates.txt");
        FileManager.saveAmountOfIDs("IDAmount.txt");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
