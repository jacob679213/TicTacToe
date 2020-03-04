/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author 679213
 */
public class Player {
    private boolean[][] positions;
    
    public Player(){
        this.positions = new boolean[3][3];
        
        for(int i = 0; i < positions.length; i++){
            for(int j = 0; j < positions[i].length; j++){
                positions[i][j] = false;
            }
        }
    }
    
    public void checkWin(){
    
    }
    
    public void newPos(int x, int y){
        positions[x][y] = true;
    }
    
    public boolean[][] getPos(){
        return this.positions;
    }
}
