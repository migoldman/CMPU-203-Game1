/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cmpu.pkg203.game1;

/**
 *
 * @author michaelgoldman
 */
import java.util.LinkedList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;

public class TetrisWorld {
    
    static final int wWidth = 100;
    static final int wHeight = 200;
    static final int rows = 20;
    static final int columns = 10;
    static int[][] worldArray;
    int counter;
    int x;
    int y;
    int dx;
    int dy;
    Shapes user;
    LinkedList<Shapes> placedShapes;
    
    //Make the world a dense matrix of falses, then add in graphics
    public TetrisWorld(Shapes user, LinkedList<Shapes> placedShapes) {
        this.user = user;
        this.placedShapes = placedShapes;
    }
    
    //Makes an empty world (a world of 0s)
    public TetrisWorld newWorld() {
        for(int x = 0; x < columns; x++) {
            for(int y = 0; y < rows; y++) {
                worldArray[x][y] = 0;
            }
        }
        return new TetrisWorld(user.makeBlock(), placedShapes);
    }
    
    //checks if the block can keep moving down
    public boolean isPlacedHuh() {
        int xPos = user.getX();
        int yPos = user.getY();    
        for(int i = 0; i< placedShapes.size(); i++) {
            if(yPos-1 == placedShapes.get(i).getY() && 
                xPos == placedShapes.get(i).getX()) {
                return true;
            }
        }
        if(yPos == 20) {
            return true;
        }
        else {
            return false; 
        }
    }
    
    //BAD
    public TetrisWorld tick() {
    	int newX = x + dx;
    	int newY = y + dy;
    	if(newX <= 0) {
            return new TetrisWorld(this.user, this.placedShapes);    	
            }
    	if(newX >= columns) {
            return new TetrisWorld(this.user, this.placedShapes);
    	}
    	if(isPlacedHuh()) {
            placedShapes.add(user);
            return new TetrisWorld(user.makeBlock(), placedShapes);
    	}
    }
    
    //Think it is good
    public TetrisWorld keyPressed(KeyEvent e){
    	int keyCode = e.getKeyCode();
        int newX = x + dx;
        int newY = y + dy;
    	switch(keyCode) {
            case KeyEvent.VK_LEFT:
                if(newX > 0) {
                    return new TetrisWorld(this.user.setPos(x-1, y+1), this.placedShapes);   
                }
            case KeyEvent.VK_RIGHT:
                if(newX < columns) {
                    return new TetrisWorld(this.user.setPos(x+1, y+1), this.placedShapes);
                }
            case KeyEvent.VK_UP:
                if()
    		return new TetrisWorld(this.user.rotate(),this.placedShapes);
            default:
                return new TetrisWorld(this.user, this.placedShapes);
    	}
    }
}
