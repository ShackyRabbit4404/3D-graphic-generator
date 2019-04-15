public class Vector{
    double[] loc;
    public Vector(int X,int Y,int Z){
        loc = new double[]{X,Y,Z};
    }
    public void transformX(int x){
        loc[0] += x;
    }
    public void transformY(int y){
        loc[1] += y;
    }
    public void transformZ(int z){
        loc[2] += z;
    }
}