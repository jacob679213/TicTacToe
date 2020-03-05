/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Graphics;

/**
 *This class is just used to store a square in the game
 * @author 679213
 */
public class Location {
    private int x;
    private int y;
    private boolean taken = false;
    
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void drawX(Graphics g){
        if(this.taken){
            g.drawString("X", x+50, y-50);
        }
    }
    
    public void drawO(Graphics g){
        if(taken){
            g.drawString("O", x+50, y-50);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean isTaken(){
        return taken;
    }
    
    public void setTaken(boolean taken){
        this.taken = taken;
    }
}
