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
public class Enemy extends Player{
    private int dif;
    private boolean[][] otherPos;
    public Enemy(int dificulty){
        super();
        this.dif = dificulty;
        this.otherPos = new boolean[3][3];
    }
    
    /**
     * Allows the enemy to take a turn. Difficulty 1 will place randomly, 
     * difficulty 3 will use algorithms that ensure a win or cat game.
     * @param lastX
     * @param lastY
     * @param pos 
     */
    public void turn(int lastX, int lastY, Location[][] pos){
        this.otherPos[lastX][lastY] = true;
        
        if(this.dif == 1){
            boolean running = true;
            while(running){
                int tempX = (int)(Math.random() * 3);
                int tempY = (int)(Math.random() * 3);
                
                if(tempX == 3 || tempY == 3){
                    System.out.print("AAAAAAAAAAAAAAAAAAAAAAAA");
                }
                
                if(super.getPos()[tempX][tempY] || this.otherPos[tempX][tempY]){
                    continue;
                }
                else{
                    super.newPos(tempX, tempY);
                    pos[tempX][tempY].setTaken(true);
                    break;
                }
                
            }
        }
        else if(this.dif == 2){}
        else if(this.dif == 3){}
    }
}
