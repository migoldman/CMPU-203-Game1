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
    

    static final int rows = 20;
    static final int columns = 10;
    static int[][] worldArray;
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
        return new TetrisWorld(user.makeBlock(user.randomInt()), placedShapes);
    }
    

    
    //checks if the block can keep moving down
    public boolean isPlacedHuh() {
        int xPos = user.x;
        int yPos = user.y;    
        for(int i = 0; i< placedShapes.size(); i++) {
            if(yPos-1 == placedShapes.get(i).y && 
                xPos == placedShapes.get(i).x) {
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
    /*public TetrisWorld tick() {
    	int newX = user.x + dx;
    	int newY = user.y + dy;
    	if(newX <= 0) {
            return new TetrisWorld(this.user, this.placedShapes);    	
            }
    	if(newX >= columns) {
            return new TetrisWorld(this.user, this.placedShapes);
    	}
    	if(isPlacedHuh()) {
            placedShapes.add(user);
            return new TetrisWorld(user.makeBlock(user.randomInt()), placedShapes);
    	}
    }*/
    
    //Think it is good
    public TetrisWorld keyPressed(KeyEvent e){
    	int keyCode = e.getKeyCode();
        int x = user.x;
        int y = user.y;
        int newX = x + dx;
        int newY = y + 1;
    	switch(keyCode) {
            case KeyEvent.VK_LEFT:
                if(newX > 0) {
                    return new TetrisWorld(this.user.setPos(x-1, newY), this.placedShapes);   
                }
                else {
                    return new TetrisWorld(this.user.setPos(x, newY), this.placedShapes);
                }
            case KeyEvent.VK_RIGHT:
                if(newX < columns) {
                    return new TetrisWorld(this.user.setPos(x+1, newY), this.placedShapes);
                }
                else {
                    return new TetrisWorld(this.user.setPos(x, newY), this.placedShapes);
                }
            case KeyEvent.VK_UP:
    		return new TetrisWorld(this.user.rotate(),this.placedShapes);
            default:
                return new TetrisWorld(this.user.setPos(x, y+1), this.placedShapes);
    	}
    }
}
