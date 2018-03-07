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

    public static Vertex getVertex(int id){
        for(Vertex v: vertexes){
            if(v.getId() == id){
                return v;
            }
        }
        return null;
    }

    public static int getEdgesSize(){
        return  edges.size();
    }

    public static Edge getEdge(int id) {
        for(Edge e: edges){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }
}
