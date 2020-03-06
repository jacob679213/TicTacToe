/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 * Player class holds lots of logic methods needed for the game to work.
 * @author 679213
 */
public abstract class Player {
    private boolean[][] positions;
    
    /**
     * Constructs the Player
     */
    public Player(){
        this.positions = new boolean[3][3];
        
        for(int i = 0; i < positions.length; i++){
            for(int j = 0; j < positions[i].length; j++){
                positions[i][j] = false;
            }
        }
    }
    
    /**
     * Massive if statement checks if any of the win conditions have been met
     * @return boolean of if any condition was met
     */
    public boolean checkWin(){
        boolean responce = false;
        for(int i = 0; i < positions.length; i++){
            if(positions[i][0] && positions[i][1] && positions[i][2]){
                responce = true;
            }
            if(positions[0][i] && positions[1][i] && positions[2][i]){
                responce = true;
            }
            if(positions[0][0] && positions[1][1] && positions[2][2]){
                responce = true;
            }
            if(positions[0][2] && positions[1][1] && positions[2][0]){
                responce = true;
            }
            
        }
        return responce;
    }
    
    /**
     * Sets the position in the Player's internal memory as taken
     * @param x X position
     * @param y Y position
     */
    public void newPos(int x, int y){
        positions[x][y] = true;
    }
    
    /**
     * Sets the position if the given spot as clear
     * @param x X position
     * @param y Y position
     */
    public void delPos(int x, int y){
        positions[x][y] = false;
    }
    
    /**
     * Returns the entire internal position memory
     * @return Positions
     */
    public boolean[][] getPos(){
        return this.positions;
    }
    
    /**
     * Clears the entire position memory
     */
    public void clearPos(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                positions[i][j] = false;
            }
        }
    }
    
    /**
     * Only applicable to the Enemy class, but has to be called by a Player array
     * @param lastX Last placed X position
     * @param lastY Last placed Y position
     * @param pos   Location array
     */
    public abstract void turn(int lastX, int lastY, Location[][] pos);
}
