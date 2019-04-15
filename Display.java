import javax.swing.*;
import java.awt.*;
public class Display extends JComponent{
    double[][] points;
    Camera camera;
    int width; 
    int height;
    public Display(Camera c,int w,int h){
        points = new double[1][2];
        camera = c;
        width = w;
        height = h;
    }
    public void draw(){
        points = camera.getView();
        super.repaint();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);
        g.setColor(Color.RED);
        for(double[] p: points){
            g.fillRect((int)(p[0]*20+(width/2)),(int)((p[1]*-1)*20+(height/2)),1,1);
        }
    }
}