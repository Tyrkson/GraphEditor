package sample;


import java.io.Serializable;
import java.util.ArrayList;

public class Vertex implements Serializable{

    public static final long serialVersionUID = -6003069719504334615L;


    public String name;
    private String id;
    public ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();

    public Vertex(String name) {
        this.id = IDManager.generateID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setID(String name) {
        this.id = name;
    }
    public static int getAmountOfIds(){
        return IDManager.getAmountOfVertexIDs();
    }

}
