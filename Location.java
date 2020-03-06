/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Graphics;

/**
 * location holds a X, a Y, and a boolean saying if it's taken. It will draw an 
 * X or an O if it was taken 
 * @author 679213
 */
public class Location {
    private int x;
    private int y;
    private boolean taken = false;
    
    /**
     * Constructor for the location.
     * @param x the X position of th bottom-left corner
     * @param y the Y position of the bottom-left corner
     */
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    /**
     * Draws a X
     * @param g Graphics screen to draw on
     */
    public void drawX(Graphics g){
        if(this.taken){
            g.drawString("X", x+50, y-50);
        }
    }
    
    /**
     * Draws an O
     * @param g Graphics screen to draw on
     */
    public void drawO(Graphics g){
        if(taken){
            g.drawString("O", x+50, y-50);
        }
    }
    
    /**
     * Returns the X of the bottom-left corner
     * @return X
     */
    public int getX() {
        return x;
    }
    
    /**
     * Returns the Y of the bottom-left corner
     * @return Y
     */
    public int getY() {
        return y;
    }
    
    /**
     * Returns if the location is taken or not
     * @return Taken
     */
    public boolean isTaken(){
        return taken;
    }
    
    /**
     * Sets the value of the taken boolean
     * @param taken new value
     */
    public void setTaken(boolean taken){
        this.taken = taken;
    }
}
