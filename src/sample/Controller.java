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




    @FXML
    private Pane drawPane;


    @FXML
    public void chooseMethod(MouseEvent e){
        if(mode == 1){
            addVertex(e);
        }
    }

    private void addEdge(Point point, int id){
        if(clickCount == 0){
            pointA = new Point(point.getX(), point.getY());
            vertexIdA = id;
            clickCount++;
        }else{
            pointB = new Point(point.getX(), point.getY());
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
        l.setStroke(Color.RED);

        l.setStroke(Color.RED);


        drawPane.getChildren().add(0, l);
    }

    public void addVertex(MouseEvent e){
        Vertex vertex = new Vertex("Name");
        drawPoint(vertex.getId(), e);
    }

    private void drawPoint(int id, MouseEvent mouseE){
        Circle c = new Circle();
        c.setFill(Color.BLACK);
        c.setRadius(10);
        c.setCenterX(mouseE.getX());
        c.setCenterY(mouseE.getY());
        c.setId(String.valueOf(id));

        c.setOnMouseClicked(e ->{
            if(mode == 2) {
                int vertexID = Integer.parseInt(c.getId());

                addEdge(new Point(c.getCenterX(), c.getCenterY()), vertexID);
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
