package sample;

import java.util.ArrayList;

public class Graph {
    private static ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
    private static ArrayList<Edge> edges = new ArrayList<Edge>();

    private Graph(){
    }

    public int addVertex(String name){
        Vertex vertex = new Vertex("Nimi");
        vertexes.add(vertex);
        return vertex.getId();
    }

    public void addEdge(int vertexFromId, int vertexToID, int weight){
        edges.add(new Edge(vertexFromId, vertexToID, weight));
    }
}
