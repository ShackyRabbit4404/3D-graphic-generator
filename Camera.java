import java.util.*;
import java.awt.*;
public class Camera{
    private Vector location;
    // 0 == x, 1 == y, 2 == z
    private double[] rotation;
    private ArrayList<Vector> points;
    private double[] viewRange;
    private double width;
    private double height;
    private double viewPlaneDistance;
    boolean useMouse;
    Robot r;
    public Camera(ArrayList<Vector> v,int w,int h,double[] vr){
        location = new Vector(0,0,0);
        rotation = new double[3];
        points = v;
        width = w;
        height = h;
        viewRange = vr;
        viewPlaneDistance = 5;
        useMouse = true;
        try{
            r = new Robot();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void rotateX(int r){
        rotation[0] += r;
    }
    public void rotateY(int r){
        rotation[1] += r;
    }
    public void rotateZ(int r){
        rotation[2] += r;
    }
    public void transformX(int x){
        location.transformX(x);
    }
    public void transformY(int y){
        location.transformY(y);
    }
    public void transformZ(int z){
        location.transformZ(z);
    }
    public double[][] getView(){
        rotateX((int)((MouseInfo.getPointerInfo().getLocation().getX()-500)/5));
        rotateY((int)((MouseInfo.getPointerInfo().getLocation().getY()-500)/5));
        if(useMouse){
            r.mouseMove(500,500);
        }
        double[][] view = new double[points.size()][2];
        for(int a = 0; a < points.size(); a++){
            view[a][0] = (points.get(a).loc[0]-location.loc[0])*(viewPlaneDistance/(points.get(a).loc[2]-location.loc[2]));
            view[a][1] = (points.get(a).loc[1]-location.loc[1])*(viewPlaneDistance/(points.get(a).loc[2]-location.loc[2]));
            view[a][0] = Math.tan(Math.toRadians(Math.toDegrees(Math.atan(view[a][0]/viewPlaneDistance))-rotation[0]))*viewPlaneDistance;
            view[a][1] = Math.tan(Math.toRadians(Math.toDegrees(Math.atan(view[a][1]/viewPlaneDistance))-rotation[1]))*viewPlaneDistance;
        }
        return view;
    }   
}