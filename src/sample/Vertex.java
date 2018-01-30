package sample;

import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
public class Vertex {
    public String name;
    private int id;
    public static int amountOfIds = 0;
    public ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();

    public Vertex() {
        this.id = ++amountOfIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
