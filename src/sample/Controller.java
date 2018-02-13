package sample;

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
    private Point pointA;
    private Point pointB;
    private int vertexIdA;
    private int vertexIdB;




    private Point vertexCoords;



    @FXML
    private Pane drawPane;


    @FXML
    public void chooseMethod(MouseEvent e){
        if(mode == 1){
            addVertex(e);
        }
    }

    private void addEdge(MouseEvent e, int id){
        if(clickCount == 0){
            pointA = new Point(e.getX(), e.getY());
            vertexIdA = id;
            clickCount++;
        }else{
            pointB = new Point(e.getX(), e.getY());
            vertexIdB = id;
            Edge edge = new Edge(vertexIdA, vertexIdB, 4);
            drawLine(pointA, pointB);
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
        Vertex vertex = new Vertex("Name");
        vertexCoords = new Point(e.getX(),e.getY());
        drawPoint(vertex.getId());
    }

    private void drawPoint(int id){
        Circle c = new Circle();
        c.setFill(Color.BLACK);
        c.setRadius(10);
        c.setCenterX(vertexCoords.getX());
        c.setCenterY(vertexCoords.getY());
        c.setId(String.valueOf(id));

        c.setOnMouseClicked(e ->{
            if(mode == 2) {
                int vertexID = Integer.parseInt(c.getId());
                addEdge(e, vertexID);
            }
        });

        drawPane.getChildren().add(c);
    }
    @FXML
    public void changeModeTo2(){
        mode = 2;
    }

    @FXML
    public void changeModeTo1(){
        clickCount = 0;

        mode = 1;
    }
    @FXML
    public void changeModeTo0(){
        clickCount = 0;

        mode = 0;
    }
}
