package sample;

import java.io.Serializable;

public class Edge implements Serializable{

    public static final long serialVersionUID = -60030697195044615L;


    private String vertexFromID;
    private String vertexToID;
    private String id;
    private int weight;

    public Edge(String vertexFromID, String vertexToID, int weight){
        this.vertexFromID = vertexFromID;
        this.vertexToID = vertexToID;
        this.weight = weight;
        this.id = IDManager.generateID();
    }

    public String getVertexFromID(){
        return vertexFromID;
    }

    public String getVertexToID(){
        return vertexToID;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setID(String name) {
        this.id = name;
    }

    public static int getAmountOfIds(){
        return IDManager.getAmountOfEdgeIDs();
    }

    public static void delete(Edge edge){
        edge.id = null;
    }
}
