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
public class User extends Player{

    @Override
    public void turn(int lastX, int lastY, Location[][] pos) {
        System.out.println("Uh oh! It looks like you broke the game!");
    }
    
}
