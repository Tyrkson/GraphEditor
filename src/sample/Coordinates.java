package sample;

import java.util.HashMap;

public class Coordinates {

    private static HashMap<Integer, Point> allVertexCoordinates = new HashMap<>();

    private Coordinates(){}

    public static Point get(Integer VertexID){
        return allVertexCoordinates.get(VertexID);
    }

    public static void add(Integer vertexID, Point vertexPoint){
        allVertexCoordinates.put(vertexID, vertexPoint);
    }

    public static boolean remove(Integer vertexID){
        Point isRemoved = allVertexCoordinates.remove(vertexID);

        return isRemoved != null ;
    }

    public static HashMap<Integer, Point> getAllVertexCoordinates() {
        return allVertexCoordinates;
    }

    public static void setAllVertexCoordinates(HashMap<Integer, Point> allVertexCoordinates) {
        Coordinates.allVertexCoordinates = allVertexCoordinates;
    }
}
