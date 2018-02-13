package sample;

public class Edge {
    private int vertexFromID;
    private int vertexToID;
    private int id;
    private static int amountOfIds;
    private int weight;

    public Edge(int vertexFromID, int vertexToID, int weight){
        this.vertexFromID = vertexFromID;
        this.vertexToID = vertexToID;
        this.weight = weight;
        System.out.println(amountOfIds);
        this.id = amountOfIds;
        amountOfIds++;
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

    public int getId() {
        return id;
    }

    public static int getAmountOfIds(){
        return amountOfIds;
    }
}
