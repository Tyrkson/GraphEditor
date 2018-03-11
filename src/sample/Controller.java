package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.util.Optional;

public class Controller{


    private int mode = 0;


    //Variables for mode 2 (Edge adding)
    private int clickCount = 0;
    private Point pointA;
    private Point pointB;
    private int vertexIdA;
    private int vertexIdB;


    //Variables for dialog
    TextField input;




    @FXML
    private Pane drawPane;


    @FXML
    public void initialize() throws IOException {
        FileManager.loadCoordinates("Coordinates.txt");
        FileManager.loadGraph("Graph.txt");
        FileManager.loadEdges("Edges.txt");


        if(Coordinates.getAllVertexCoordinates().size() != 0) {
            for(Integer i : Coordinates.getAllVertexCoordinates().keySet()){
                drawPoint(i, Coordinates.get(i));
            }
            for(Edge e : Graph.getEdges()){
                drawLine(Coordinates.get(e.getVertexFromID()),
                        Coordinates.get(e.getVertexToID()), e.getId());
            }
        }
    }


    @FXML
    public void chooseMethod(MouseEvent e){
        if(mode == 1){
            Dialog<String> dialog = createSimpleDialogBox("Enter name");

            dialog.setResultConverter((ButtonType button) -> {
                if (button == ButtonType.OK) {
                    addVertex(e, input.getText());
                }
                return null;
            });

            dialog.showAndWait();
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


            Dialog<String> dialog = createSimpleDialogBox("Enter weight");

            dialog.setResultConverter((ButtonType button) -> {
                if (button == ButtonType.OK) {
                    return input.getText();
                }
                return null;
            });

            Optional<String> result = dialog.showAndWait();
            result.ifPresent((String weight) ->{
                    int w;
                    try {
                        w = Integer.parseInt(weight);
                    }catch (NumberFormatException e){
                        w = 5;
                    }

                    Edge edge = new Edge(vertexIdA, vertexIdB, w);
                    Graph.getVertex(vertexIdA).adjacentEdges.add(edge);
                    Graph.getVertex(vertexIdB).adjacentEdges.add(edge);
                    Graph.addEdge(edge);
                    drawLine(pointA, pointB, edge.getId());
            });


            clickCount--;
        }
    }

    private void drawLine(Point a, Point b, int id) {
        Line l = new Line();

        l.setStartX(a.getX());
        l.setStartY(a.getY());

        l.setEndX(b.getX());
        l.setEndY(b.getY());
        l.setStroke(Color.RED);

        l.setStroke(Color.RED);

        l.setId(String.valueOf(id));


        drawPane.getChildren().add(0, l);
    }

    public void addVertex(MouseEvent e, String name){
        Vertex vertex = new Vertex(name);
        Graph.addVertex(vertex);
        drawPoint(vertex.getId(), new Point(e.getX(), e.getY()));
    }

    private void drawPoint(int id, Point point){
        Circle c = new Circle();
        c.setFill(Color.BLACK);
        c.setRadius(10);
        c.setCenterX(point.getX());
        c.setCenterY(point.getY());
        c.setId(String.valueOf(id));
        Coordinates.add(id, new Point(c.getCenterX(), c.getCenterY()));

        c.setOnMouseClicked(e ->{
            if(mode == 2) {
                int vertexID = Integer.parseInt(c.getId());

                addEdge(new Point(c.getCenterX(), c.getCenterY()), vertexID);
            }
        });

        c.setOnMouseDragged(e ->{
            if(mode == 0) {
                dragVertex(c, e);
            }
        });

        drawPane.getChildren().add(c);
    }

    private void dragVertex(Circle c, MouseEvent e) {
        c.setCenterX(e.getX());
        c.setCenterY(e.getY());

        Vertex v = Graph.getVertex(Integer.parseInt(c.getId()));

        Coordinates.add(v.getId(), new Point(e.getX(), e.getY()));

        for(Edge edge: v.adjacentEdges){
            int id = edge.getId();
            removeLine(id);
            getPointsAndCallDrawLine(edge);
        }
    }

    private void getPointsAndCallDrawLine(Edge edge) {
        int a = edge.getVertexFromID();
        int b = edge.getVertexToID();
        Point pointA = Coordinates.get(a);
        Point pointB = Coordinates.get(b);
        drawLine(pointA, pointB, edge.getId());
    }

    private void removeLine(int id) {
        Line l = null;
        for(Node n: drawPane.getChildren()){
            if(n instanceof Line){
                if(Integer.parseInt(n.getId()) == id){
                    l = (Line) n;
                    break;
                }
            }
        }
        if(l != null) drawPane.getChildren().remove(l);
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

    private Dialog<String> createSimpleDialogBox(String title){
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle(title);

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        input = new TextField();

        dialogPane.setContent(new VBox(3, input));

        return dialog;
    }
}
