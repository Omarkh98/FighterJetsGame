/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Omar Khaled
 */
public class BallMovements extends JPanel implements Runnable {
    
   public ArrayList<Targets> Target= new ArrayList<Targets>();
   public MyJet FighterJet = new MyJet("C:\\Users\\oo\\Pictures\\jet-clipart-fighter-jet-10.png");
   
   public BallMovements()
    {
        setSize(700,700);
        setBackground(Color.RED);
        FighterJet.Position.x=200;
        FighterJet.Position.y=400;
        addKeyListener(new GameButtons());
    }
   
   private class GameButtons implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            
            if (e.getKeyCode()==KeyEvent.VK_RIGHT) {   //Right Button Press.
                FighterJet.MoveFor();
            }
            
            if (e.getKeyCode()==KeyEvent.VK_LEFT) {  // Left Button Press.
                FighterJet.MoveBack();
            }
            
            if (e.getKeyCode()==KeyEvent.VK_SPACE) { // Space Button Press.
                FighterJet.Fire();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_UP) {
                FighterJet.MoveUp();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                FighterJet.MoveDown();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
   
   public void  paintComponent(Graphics g) {
   
        g.clearRect(0, 0, 700, 700);
        try {
        BufferedImage Jet = ImageIO.read(new File(FighterJet.Path));
        BufferedImage Rocket = ImageIO.read(new File(FighterJet.Rocket.ImagePath));
        g.drawImage(Jet, FighterJet.Position.x, FighterJet.Position.y,null);
        g.drawImage(Rocket, FighterJet.Rocket.Position.x, FighterJet.Rocket.Position.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        for (Targets T: Target) {   // Iterator For - Loop On the Targets / Objects
            g.setColor(T.Col);
            g.fillOval(T.X,T.Y, 40, 40);
            
            if (FighterJet.Rocket.Position.distance(T.X, T.Y)<=100) {
                System.out.println("Hit Occurs" + T.Col.toString());
                Target.remove(T);
                break;  
            }
        } 
    }
   
     @Override
     public void run() {
      try {
      while(true) {
        for (Targets T: Target)
        {
            T.MoveBalls(getWidth());
        }    
        Thread.sleep(50);  // Wait or Pause for 50 MilliSeconds.
        repaint();
    }
    }
    catch (InterruptedException e){}
    }
}
