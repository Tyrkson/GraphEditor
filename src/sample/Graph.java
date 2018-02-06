package sample;

import java.util.ArrayList;

public class Graph {
    private static ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
    private static ArrayList<Edge> edges = new ArrayList<Edge>();

    private Graph(){
    }

    public void addVertex(Vertex vertex){
        vertexes.add(vertex);
    }

    public void addEdge(Edge edge){
        edges.add(edge);
    }
}
