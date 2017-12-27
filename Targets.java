/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;
import java.awt.Color;
import static javax.swing.Spring.width;

/**
 *
 * @author Omar Khaled
 */
public class Targets {
    public int X;
    public int Y;
    public int SpeedOfX;
    public Color Col;
    
    public Targets(int x,int y,int SpeedX,Color C) { // Overridden Constructor.
        X = x;
        Y = y;
        SpeedOfX = SpeedX;
        Col = C;
    }
    
    public Targets() {   // Main Constructor.
        X = 0;
        Y = 0;
        SpeedOfX = 20;
        Col = Color.RED;
    }
    
    public void MoveBalls(int ScreenWidth) { // Adjust Ball Movements With the Screen Borders
        X += SpeedOfX;
        if ( X + 50 > ScreenWidth)
        {
            SpeedOfX = - SpeedOfX;
        }
        if (X < 0)
        {
            SpeedOfX = -SpeedOfX;
        }
    }
}
