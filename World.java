/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 * The rest of the game takes place in the world. World is kind of like the main
 * method, for the main method? Its hard to explain. 
 * @author Jehcoob
 */

public class World extends JPanel implements MouseListener{
    private Timer timer;
    private final Location[][] positions;
    ArrayList<Player> players = new ArrayList<>();
    Scanner kb = new Scanner(System.in);
    int turn = 1;
    int playerCount;
    

    /**
     * Creates the world
     */
    public World() {
        super();
        
        System.out.println("How many players will there be?");
        boolean temp = true;
        while(temp){
            int playerNum = kb.nextInt();
            if(playerNum == 0){
                Enemy temp1 = new Enemy(3);
                Enemy temp2 = new Enemy(3);

                players.add(temp1);
                players.add(temp2);
                playerCount = playerNum;
                temp = false;
            }
            else if(playerNum == 1){
                System.out.println("Choose a dificulty: ");
                int dificulty = kb.nextInt();
                User temp1 = new User();
                Enemy temp2 = new Enemy(dificulty);

                players.add(temp1);
                players.add(temp2);
                playerCount = playerNum;
                temp = false;
            }
            else if(playerNum == 2){
                User temp1 = new User();
                User temp2 = new User();
            
                players.add(temp1);
                players.add(temp2);
                playerCount = playerNum;
                temp = false;
            }
            else{
                System.out.println("Invalad Number");
            }
        }
        this.positions = new Location[3][3];
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/12);
        
        addMouseListener(this);
        
         //Setting up the Positions array
         
         positions[0][0] = new Location(250,450);
         positions[1][0] = new Location(350,450);
         positions[2][0] = new Location(450,450);
         positions[0][1] = new Location(250,350);
         positions[1][1] = new Location(350,350);
         positions[2][1] = new Location(450,350);
         positions[0][2] = new Location(250,250);
         positions[1][2] = new Location(350,250);
         positions[2][2] = new Location(450,250);
    }

    @Override
    /**
     * Sets up the world
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Create the tic-tac-toe field
        g.fillRect(350, 150, 5, 300);
        g.fillRect(450, 150, 5, 300);
        
        g.fillRect(250, 250, 300, 5);
        g.fillRect(250, 350, 300, 5);
        
        boolean[][] temp1 = players.get(0).getPos();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(temp1[i][j]){
                    positions[i][j].drawX(g);
                }
            }
        }
        
        boolean[][] temp2 = players.get(1).getPos();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(temp2[i][j]){
                    positions[i][j].drawO(g);
                }
            }
        }
        
        for(int i = 0; i < players.size(); i++){
            if(players.get(i).checkWin()){
                System.out.println("Player number " + (i+1) + " has won the game!");
                clearGame();
            }
        }
        
        int temp = 0;
        for(int i = 0; i < positions.length; i++){
            for(int j = 0; j < positions[i].length; j++){
                if(positions[i][j].isTaken()){
                    temp++;
                }
            }
        }
        if(temp == 9){
            System.out.println("Cat Game!");
            clearGame();
        }
    }
    
    public void clearGame(){
            for(int i = 0; i < players.size(); i++){
                    players.get(i).clearPos();
                }
                for(int i = 0; i < positions.length; i++){
                    for(int j = 0; j < positions[i].length; j++){
                        positions[i][j].setTaken(false);
                    }
                }
                turn = 1;
                repaint();
        }

    /**
     * Runs whenever the Timer is called, and allows the frame to repaint/update itself
     */
    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {         
            repaint();
        }
    }
    
    /**
     * Uses a switch statement to test the given key inputs, and respond accordingly
     * @param e Keyboard input
     */
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_C:
                clearGame();
                break;
        }
    }
    /**
     * Uses a switch statement to test if a key is released, and responds accordingly
     * @param e Keyboard input
     */
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_Q:
                //code block
                break;
        }
    }
    
    
    
    /**
     * Tests if the mouse is pressed and released
     * @param e Mouse Event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    
    
    
    /**
     * Tests if the mouse is pressed
     * @param e Mouse Event
     */
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    /**
     * Tests if the mouse is released
     * @param e Mouse Event
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        //check if mouse is in a location
        for(int i = 0; i < positions.length; i++){
            for(int j = 0; j < positions[i].length; j++){
                Location temp = positions[i][j];
                if(e.getX() > temp.getX() && e.getX() < temp.getX() + 100 && e.getY() < temp.getY() && e.getY() > temp.getY() - 100){
                    
                    if(playerCount == 2){
                        if(turn == 1){
                            if(!temp.isTaken()){
                                players.get(0).newPos(i, j);
                                temp.setTaken(true);
                                turn = 2;
                            }
                            else{
                                System.out.println("This spot is taken");
                            }
                        }
                        else{
                            if(!temp.isTaken()){
                                players.get(1).newPos(i, j);
                                temp.setTaken(true);
                                turn = 1;
                            }
                            else{
                                System.out.println("This spot is taken");
                            }
                        }
                        System.out.println("Mouse clicked in position ("+i+", "+j+")");
                    }
                    if(playerCount == 1){
                        if(!temp.isTaken()){
                            players.get(0).newPos(i, j);
                            temp.setTaken(true);
                            turn++;
                            
                            if(turn < 9){
                                players.get(1).turn(i, j, positions);
                                turn++;
                            }
                        }
                    }
                }
                
            }
        }
    }

    /**
     * Tests if the mouse enters the frame
     * @param e Mouse Event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    /**
     * Tests if the mouse exits the frame
     * @param e Mouse Event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
