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

    private void addEdge(MouseEvent e){
        if(clickCount == 0){
            vertexFromID = new Point(e.getX(), e.getY());
            clickCount++;
        }else{
            vertextToID = new Point(e.getX(), e.getY());
            drawLine(vertexFromID, vertextToID);
            clickCount--;
        }



    }

    private void drawLine(Point a, Point b) {
        Line l = new Line();

        l.setStartX(a.getX());
        l.setStartY(a.getY());

        l.setEndX(b.getX());
        l.setEndY(b.getY());



        drawPane.getChildren().add(l);
    }

    @FXML
    public void changeModeTo2(){
        mode = 2;
    }

    @FXML
    public void changeModeTo0(){
        clickCount = 0;

        mode = 0;
    }
}
