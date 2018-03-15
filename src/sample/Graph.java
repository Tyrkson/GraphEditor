package sample;

import java.util.ArrayList;

public class Graph {
    private static ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
    private static ArrayList<Edge> edges = new ArrayList<Edge>();

    private Graph(){
    }

    public static void addVertex(Vertex vertex){
        vertexes.add(vertex);
    }

    public static void addEdge(Edge edge){
        edges.add(edge);
    }

    public static int getVertexesSize(){
        return vertexes.size();
    }

    public static Vertex getVertex(String id){
        for(Vertex v: vertexes){
            if(v.getId().equals(id)){
                return v;
            }
        }
        return null;
    }

    public static int getEdgesSize(){
        return  edges.size();
    }

    public static Edge getEdge(String id) {
        for(Edge e: edges){
            if(e.getId().equals(id)){
                return e;
            }
        }
        return null;
    }

    public static void removeVertex(Vertex v) {
        vertexes.remove(v);
    }
    public static void removeEdge(Edge e) {
        edges.remove(e);
    }
    public static ArrayList<Vertex> getVertexes() {
        return vertexes;
    }

    public static ArrayList<Edge> getEdges() {
        return edges;
    }

    public static void setVertexes(ArrayList<Vertex> vertexes) {
        Graph.vertexes = vertexes;
    }

    public static void setEdges(ArrayList<Edge> edges) {
        Graph.edges = edges;
    }
}
