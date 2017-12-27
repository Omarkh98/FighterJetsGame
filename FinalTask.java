/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

import java.util.Date;

/**
 *
 * @author Omar Khaled
 */
public class FinalTask extends Thread {  // Using Threads in Game.
    int ID;
    
    public FinalTask(int id) {
        ID=id;
    }
    
    public void run() {
        for (int i=0;i<150;i++) {
            Date D =new Date();
            System.out.println(D.getTime()+" : I am thread " + ID + " Printing " + i);
        }
    }
}
