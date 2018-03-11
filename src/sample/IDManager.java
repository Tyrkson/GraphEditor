package sample;

import java.util.UUID;

public class IDManager {
    private static int amountOfVertexIDs = 0;
    private static int amountOfEdgeIDs = 0;
    private IDManager(){
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
    public static String setCustomID(String name) {
        return UUID.nameUUIDFromBytes(name.getBytes()).toString();
    }
    public static long getAmountOfIDs(){
        return amountOfVertexIDs + amountOfEdgeIDs;
    }
    public static void reduceAmountOfVertexIDs(int amount) {
        if(amountOfVertexIDs >= amount) amountOfVertexIDs -= amount;
        else amountOfVertexIDs = 0;
    }
    public static void incrementAmountVertexOfIDs(int amount) {
        amountOfVertexIDs += amount;
    }
    public static void reduceAmountOfEdgeIDs(int amount) {
        if(amountOfEdgeIDs >= amount) amountOfEdgeIDs -= amount;
        else amountOfEdgeIDs = 0;
    }
    public static void incrementAmountEdgeOfIDs(int amount) {
        amountOfEdgeIDs += amount;
    }
    public static int getAmountOfVertexIDs(){
        return amountOfVertexIDs;
    }
    public static int getAmountOfEdgeIDs(){
        return amountOfEdgeIDs;
    }
    public static void setAmountOfVertexIDs(int amount) {
        amountOfVertexIDs = amount;
    }
    public static void setAmountOfEdgeIDs(int amount) {
        amountOfEdgeIDs = amount;
    }
}
