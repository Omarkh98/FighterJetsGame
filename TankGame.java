/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author oo
 */
public class TankGame {

    public static void main(String[] args) {
        
        FinalTask [] ArrayOfTasks = new FinalTask[100];
        for (int i=0;i<100;i++) {
            ArrayOfTasks[i] = new FinalTask(i); 
        }
        
        JFrame JF=new JFrame();
        JF.setTitle("FighterJets");
        JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JF.setVisible(true);
        BallMovements BM = new BallMovements();
        BM.setFocusable(true);
        Thread Thr = new Thread(BM);  // Fire All Balls At The Same Time.
        JF.setSize(700, 700);
        JF.add(BM,BorderLayout.CENTER);
        
        BM.Target.add(new Targets());
        BM.Target.add(new Targets(100,80,30,Color.CYAN));
        BM.Target.add(new Targets(160,160,25,Color.RED));
        BM.Target.add(new Targets(180,180,20,Color.BLACK));
        BM.Target.add(new Targets(200,200,15,Color.YELLOW));
        BM.Target.add(new Targets(220,220,10,Color.PINK));
        BM.Target.add(new Targets(240,240,5,Color.ORANGE));
        BM.Target.add(new Targets(260,220,5,Color.BLUE));

        Thr.start(); // Fire Thread.  
    } 
}
