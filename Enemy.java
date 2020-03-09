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
        
        for(int i = 0; i < otherPos.length; i++){
            for(int j = 0; j < otherPos[i].length; j++){
               otherPos[i][j] = false;
            }
        }
    }
    
    /**
     * Allows the enemy to take a turn. Difficulty 1 will place randomly, 
     * difficulty 3 will use algorithms that ensure a win or cat game.
     * @param lastX
     * @param lastY
     * @param pos 
     */
    public void turn(int lastX, int lastY, Location[][] pos){
        System.out.println("Enemy recieved data");
        this.otherPos[lastX][lastY] = true;
        
        if(this.dif == 1){
            boolean running = true;
            while(running){
                System.out.println("While loop started");
                int tempX = (int)(Math.random() * 3);
                int tempY = (int)(Math.random() * 3);
                System.out.println("("+ tempX + ", " + tempY + ")");
                
                if(super.getPos()[tempX][tempY] || this.otherPos[tempX][tempY]){
                    System.out.println("This = " + super.getPos()[tempX][tempY] + ", Other = " + otherPos[tempX][tempY]);
                    System.out.println("While loop restarting");
                    continue;
                }
                else{
                    super.newPos(tempX, tempY);
                    pos[tempX][tempY].setTaken(true);
                    running = false;
                    break;
                }
                
            }
        }
        else if(this.dif == 2){}
        else if(this.dif == 3){}
    }
}
