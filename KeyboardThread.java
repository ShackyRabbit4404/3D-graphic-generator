import java.awt.event.*;
public class KeyboardThread extends KeyAdapter {
    Camera camera;
    public KeyboardThread(Camera c){
        camera = c;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
            camera.transformY(1);
        }
        if(key == KeyEvent.VK_DOWN){
            camera.transformY(-1);
        }
        if(key == KeyEvent.VK_RIGHT){
            camera.transformX(1);
        }
        if(key == KeyEvent.VK_LEFT){
            camera.transformX(-1);
        }
        if(key == KeyEvent.VK_W){
            camera.transformZ(1);
        }
        if(key == KeyEvent.VK_S){
            camera.transformZ(-1);
        }
        if(key == KeyEvent.VK_D){
            camera.rotateX(-1);
        }
        if(key == KeyEvent.VK_G){
            camera.rotateX(1);
        }
        if(key == KeyEvent.VK_R){
            camera.rotateY(1);
        }
        if(key == KeyEvent.VK_F){
            camera.rotateY(-1);
        }
    }
}