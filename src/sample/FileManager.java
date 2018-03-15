package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileManager {


    private FileManager(){}

    public static void saveGraph(String fn, String fn2) throws IOException {
        FileOutputStream fos = new FileOutputStream(fn);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(Graph.getVertexes());
        oos.flush();
        oos.close();

        fos = new FileOutputStream(fn2);
        oos = new ObjectOutputStream(fos);

        oos.writeObject(Graph.getEdges());
        oos.flush();
        oos.close();


    }

    public static void saveCoordinates(String fn) throws IOException {
        FileOutputStream fos = new FileOutputStream(fn);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(Coordinates.getAllVertexCoordinates());
        oos.flush();
        oos.close();
    }


    public static void loadGraph(String fn) throws IOException {
        FileInputStream fis = new FileInputStream(fn);
        try{
            ObjectInputStream ois = new ObjectInputStream(fis);

            Graph.setVertexes((ArrayList<Vertex>) ois.readObject());
        }catch (EOFException e){

        } catch (ClassNotFoundException e) {
            Graph.setVertexes(new ArrayList<>());
        }
    }

    public static void loadCoordinates(String fn) throws IOException {
        FileInputStream fis = new FileInputStream(fn);
        try{
            ObjectInputStream ois = new ObjectInputStream(fis);

            Coordinates.setAllVertexCoordinates((HashMap<String, Point>) ois.readObject());

        }catch (EOFException e){

        } catch (ClassNotFoundException e) {
            Coordinates.setAllVertexCoordinates(new HashMap<>());
        }
    }

    public static void loadEdges(String fn) throws IOException {
        FileInputStream fis = new FileInputStream(fn);
        try{
            ObjectInputStream ois = new ObjectInputStream(fis);

            Graph.setEdges((ArrayList<Edge>) ois.readObject());
        }catch (EOFException e){

        } catch (ClassNotFoundException e) {
            Graph.setEdges(new ArrayList<>());
        }
    }

}
