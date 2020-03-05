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
    
    public void newPos(int x, int y){
        positions[x][y] = true;
    }
    
    public void delPos(int x, int y){
        positions[x][y] = false;
    }
    
    public boolean[][] getPos(){
        return this.positions;
    }
    
    public void clearPos(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                positions[i][j] = false;
            }
        }
    }
}
