package sample;

public class Edge {
    private int vertexFromID;
    private int vertexToID;
    private int weight;

    public Edge(int vertexFromID, int vertexToID, int weight){
        this.vertexFromID = vertexFromID;
        this.vertexToID = vertexToID;
        this.weight = weight;
    }

    public int getVertexFromID(){
        return vertexFromID;
    }

    public int getVertexToID(){
        return vertexToID;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
}
