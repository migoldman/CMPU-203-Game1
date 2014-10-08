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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;

public class TetrisWorld {
    
    static final int wWidth = 800;
    static final int wHeight = 1600;
    static final int side = 80;
    static final int rows = wWidth/side;
    static final int columns = wHeight/side;
    static int[][] worldArray = new int[columns][rows];
    int counter;
    int x;
    int y;
    int dx;
    int dy;
    Shapes user;
    List placedShapes;
    
    public TetrisWorld(Shapes user, List placedShapes, int x, int y, int dx, int dy) {
        this.user = user;
        this.placedShapes = placedShapes;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
    
    public TetrisWorld tick() {
    	int newX = x + dx;
    	int newY = y + dy;
    	if(newX <= 0) {
    		return new TetrisWorld(this.user, this.placedShapes, this.x, this.y, 0, -dy);    	
    		}
    	if(newX >= columns) {
    		return new TetrisWorld(this.user, this.placedShapes, this.x, this.y, 0, -dy);
    	}
    	if(newY == 0) {
    		return new TetrisWorld(user.isPlaced(), placedShapes, x, y,0,0);
    	}
    }
    
    public TetrisWorld keyPressed(KeyEvent e){
    	int keyCode = e.getKeyCode();
    	switch(keyCode) {
    	case KeyEvent.VK_LEFT:
    		return new TetrisWorld(this.user, this.placedShapes, this.x, this.y, dx, -dy);   
    	case KeyEvent.VK_RIGHT:
    		return new TetrisWorld(this.user, this.placedShapes, this.x, this.y, -dx, -dy);
    	case KeyEvent.VK_DOWN:
    		return new TetrisWorld(this.user, this.placedShapes, this.x, this.y, 0, -dy*2);
    	case KeyEvent.VK_UP:
    		return new TetrisWorld(this.user.rotate(),this.placedShapes, this.x, this.y, 0, -dy);
		default:
			return new TetrisWorld(this.user, this.placedShapes, this.x, this.y, 0, -dy);
    	}
    }
 
    public static void main(String[] args) {
    }
    
}
