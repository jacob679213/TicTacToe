/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *This class is just used to store a square in the game
 * @author 679213
 */
public class Location {
    private int x;
    private int y;
    
    private boolean hasX = false;
    private boolean hasO = false;
    
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasX() {
        return hasX;
    }

    public void setHasX(boolean hasX) {
        this.hasX = hasX;
    }

    public boolean hasO() {
        return hasO;
    }

    public void setHasO(boolean hasO) {
        this.hasO = hasO;
    }
    
    
    
}
