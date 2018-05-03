package sample;


import java.util.*;

public class ShortestPath {
    static class greater implements Comparator<String[]> {
        public int compare (String[] p1, String[] p2) {
            if(Long.parseLong(p1[1]) > Long.parseLong(p2[1])) return 1;
            else if(Long.parseLong(p1[1]) < Long.parseLong(p2[1])) return -1;
            else return 0;
        }
    }
    private static Comparator<String[]> comparator = new greater();
    private static PriorityQueue<String[]> unSettled;
    private static Map<Vertex, Boolean> traversedVertexes;
    private static Map<Vertex, Long> minDistances;
    private static Map<Vertex, Vertex> parents;

    private static String startID;
    private static String endID;
    private ShortestPath(){
    }

    private static void init(String start, String end){
        startID = start;
        endID = end;
        traversedVertexes = new HashMap<>();
        for (Vertex v: Graph.getVertexes()) {
                traversedVertexes.put(v,false);
        }
        minDistances = new HashMap<>();
        for (Vertex v: Graph.getVertexes()) {
            minDistances.put(v,Long.MAX_VALUE);
        }
        unSettled = new PriorityQueue<String[]>(comparator);
        unSettled.add(new String[]{startID,Long.toString(0)});
        minDistances.replace(Graph.getVertex(startID),(long)0);
        parents = new HashMap<>();
    }

    private static void computeDistances(){
        while(!unSettled.isEmpty()) {
            String[] minimum = unSettled.poll();
            Vertex minVertex = Graph.getVertex(minimum[0]);
            long minDistToMinVertex = Long.parseLong(minimum[1]);
            traversedVertexes.replace(minVertex,true);
            List<Edge> neighbourgs = minVertex.adjacentEdges;
            for (Edge e:neighbourgs) {
                if(!isTraversed(e.getVertexToID()) && (minDistToMinVertex
                        + e.getWeight() < minDistances.get(Graph.getVertex(e.getVertexToID())))) {
                    minDistances.replace(Graph.getVertex(e.getVertexToID()), (minDistToMinVertex + e.getWeight()));
                    unSettled.add(new String[]{e.getVertexToID(), Long.toString(minDistances.get(Graph.getVertex(e.getVertexToID())))});
                    parents.put(Graph.getVertex(e.getVertexToID()),Graph.getVertex(e.getVertexFromID()));
                }
            }
        }
    }
    private static boolean isTraversed(String id) {
        if(traversedVertexes.get(Graph.getVertex(id)) != null) {
            return traversedVertexes.get(Graph.getVertex(id));
        }
        else return true;
    }

    public static ArrayList<Vertex> calculateAndGetPath(String startId,String endId) {
        init(startId,endId);
        computeDistances();
        ArrayList<Vertex> path = getPath(Graph.getVertex(endID));
        if(path != null && minDistances.get(Graph.getVertex(endID)) != Long.MAX_VALUE) {
            /*System.out.println("Distance: " + minDistances.get(Graph.getVertex(endID)));
            int counter = 1;
            for (Vertex v:path) {
                System.out.print(v.getName());
                if(counter < path.size()) System.out.print(" -> ");
                counter++;
            }
            System.out.println();*/
            return path;
        }
        else{
            System.out.println("Cannot find distance");
            return null;
        }
    }

    private static ArrayList<Vertex> getPath(Vertex target) {
        ArrayList<Vertex> path = new ArrayList<Vertex>();
        Vertex step = target;

        if (parents.get(step) == null) {
            return null;
        }
        path.add(step);
        while (parents.get(step) != null) {
            step = parents.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }
}
