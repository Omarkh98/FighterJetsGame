/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.Point;

/**
 *
 * @author Omar Khaled
 */
public class MyJet {
    public Point Position =new Point();
    public String Path;
    public MyBullets Rocket =new MyBullets();
    public int Speed;
    
    public MyJet(String MyPath) {
        Speed = 30;
        Path = MyPath;
        Rocket.ImagePath="C:\\Users\\oo\\Pictures\\rocketss.jpg";
    }
    
    public void MoveFor() {  // Increase Position With Speed.
        Position.x += Speed;
    }
    
    public void MoveBack() { // Decrease Position With Speed.
        Position.x -= Speed;
    }
    
    public void Fire() {
        Rocket.Position.x = Position.x; // Rocket Directions on X and Y Axis.
        Rocket.Position.y = Position.y+200;
        Thread Thr=new Thread (Rocket);
        Thr.start(); // Fire Thread.
    }
    
    public void MoveUp(){
        Position.y -= Speed;
    }
    
    public void MoveDown(){
        Position.y += Speed;
    }
}
