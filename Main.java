import javax.swing.*;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Window");
        int width = 1000;
        int height = 1000;
        ArrayList<Vector> points = new ArrayList<Vector>();
        for(int a = 1; a < 5; a++){
            for(int b = 0; b < 10; b++){
                for(int c = 0; c < 10; c++){
                    points.add(new Vector(20*b,20*c,50*a));
                }
            }
        }
        Camera camera = new Camera(points,width,height,new double[]{0.5,0.5});
        Display screen = new Display(camera,width,height);
        KeyboardThread keyboard = new KeyboardThread(camera);
        frame.add(screen);
        frame.addKeyListener(keyboard);
        frame.setSize(width,height);
        frame.setVisible(true);
        while(true){
            screen.draw();
            try{
                Thread.sleep(10);
            }
            catch(Exception e){
                System.out.println();
            }
        }
    }
}