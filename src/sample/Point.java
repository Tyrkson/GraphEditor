package sample;

import java.io.Serializable;

public class Point implements Serializable{

    public static final long serialVersionUID = -6069719504334615L;


    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public double getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }
}
