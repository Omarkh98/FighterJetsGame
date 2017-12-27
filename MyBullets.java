/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author oo
 */
public class MyBullets implements Runnable {
    
    public Point Position = new Point();
    public Color CColor;
    public int Speed;
    public int i;
    public String ImagePath;
    
    public MyBullets()
    {
        Speed = 1;
    }
    
    public  void  Move() // Decrease Speed.
    {
        Position.y -= Speed;
    }
    
    @Override
    public void run() {
        for (i=0; i<400; i++) {   
            Move();
        } try {
             Thread.sleep(10);   // Wait or Pause 10 MilliSeconds
            } catch (InterruptedException ex) {}
        }
}
