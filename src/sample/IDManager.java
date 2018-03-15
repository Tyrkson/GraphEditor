package sample;

import java.util.UUID;

public class IDManager {
    private IDManager(){
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
    public static String setCustomID(String name) {
        return UUID.nameUUIDFromBytes(name.getBytes()).toString();
    }
    public static long getAmountOfIDs(){
        return Graph.getEdgesSize() + Graph.getVertexesSize();
    }
    public static int getAmountOfVertexIDs(){
        return Graph.getVertexesSize();
    }
    public static int getAmountOfEdgeIDs(){
        return Graph.getEdgesSize();
    }
}
