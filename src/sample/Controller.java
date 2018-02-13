package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller extends Application{
    public int createVertex() {
        Vertex vertex = new Vertex("Name");
        Graph.addVertex(vertex);
        return vertex.getId();
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("Mouse clicked");
            }
        });



        Scene scene = new Scene(root,600,500);
        stage.setTitle("Graph editor");
        stage.setScene(scene);
        stage.show();
    }
}
