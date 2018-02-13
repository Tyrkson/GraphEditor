package sample;


import java.util.ArrayList;

//import java.util.ArrayList;
public class Vertex {
    public String name;
    private int id;
    private static int amountOfIds = 0;
    public ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();

    public Vertex(String name) {
        this.id = amountOfIds;
        this.name = name;

        amountOfIds++;
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

    public static int getAmountOfIds(){
        return amountOfIds;
    }

}
