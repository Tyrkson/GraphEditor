package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Controller{


    private int mode = 0;


    //Variables for mode 2 (Edge adding)
    private int clickCount = 0;
    private Point vertexFromID;
    private Point vertextToID;
    private Point vertexCoords;



    @FXML
    private Pane drawPane;


    @FXML
    public void chooseMethod(MouseEvent e){
        if(mode == 1){
            addVertex(e);
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

    public void addVertex(MouseEvent e){
        //Vertex vertex = new Vertex("Name");
        vertexCoords = new Point(e.getX(),e.getY());
        drawPoint();
    }

    private void drawPoint(){
        Circle c = new Circle();
        c.setFill(Color.BLACK);
        c.setRadius(10);
        c.setCenterX(vertexCoords.getX());
        c.setCenterY(vertexCoords.getY());
        drawPane.getChildren().add(c);
    }
    @FXML
    public void changeModeTo2(){
        mode = 2;
    }

    @FXML
    public void changeModeTo1(){
        mode = 1;
    }
    @FXML
    public void changeModeTo0(){
        clickCount = 0;

        mode = 0;
    }
}
