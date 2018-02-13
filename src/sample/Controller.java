package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Controller{


    private int mode = 0;


    //Variables for mode 2 (Edge adding)
    private int clickCount = 0;
    private Point vertexFromID;
    private Point vertextToID;



    @FXML
    private Pane drawPane;


    @FXML
    public void chooseMethod(MouseEvent e){
        if(mode == 1){
            //addVertex
        }

        if(mode == 2){
            addEdge(e);
        }
    }

    @FXML
    public void addEdge(MouseEvent e){
        System.out.println(clickCount);
        if(clickCount == 0){
            vertexFromID = new Point(e.getX(), e.getY());
            clickCount++;
        }else{
            vertextToID = new Point(e.getX(), e.getY());
            drawLine();
            clickCount--;
        }



    }

    private void drawLine() {
        Line l = new Line();

        l.setStartX(vertexFromID.getX());
        l.setStartY(vertexFromID.getY());

        l.setEndX(vertextToID.getX());
        l.setEndY(vertextToID.getY());

        drawPane.getChildren().add(l);
    }

    @FXML
    public void changeModeTo2(){
        mode = 2;
    }
}
