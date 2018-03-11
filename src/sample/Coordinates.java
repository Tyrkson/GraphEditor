package sample;

import java.util.HashMap;

public class Coordinates {

    private static HashMap<String, Point> allVertexCoordinates = new HashMap<>();

    private Coordinates(){}

    public static Point get(String VertexID){
        return allVertexCoordinates.get(VertexID);
    }

    public static void add(String vertexID, Point vertexPoint){
        allVertexCoordinates.put(vertexID, vertexPoint);
    }

    public static boolean remove(Integer vertexID){
        Point isRemoved = allVertexCoordinates.remove(vertexID);

        return isRemoved != null ;
    }

    public static HashMap<String, Point> getAllVertexCoordinates() {
        return allVertexCoordinates;
    }

    public static void setAllVertexCoordinates(HashMap<String, Point> allVertexCoordinates) {
        Coordinates.allVertexCoordinates = allVertexCoordinates;
    }
}
