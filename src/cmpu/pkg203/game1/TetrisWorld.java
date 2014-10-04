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
import javalib.funworld.World;
import javalib.worldcanvas.WorldCanvas;
import javalib.worldimages.Posn;
import javalib.worldimages.WorldImage;
import javalib.worldimages.RectangleImage;
import java.awt.*;

public class TetrisWorld extends World {
    
    static final int wWidth = 800;
    static final int wHeight = 1600;
    static final int side = 80;
    static final int rows = wWidth/side;
    static final int columns = wHeight/side;
    int dx;
    int dy;
    public WorldImage world;
    Shapes user;
    LinkedList placedShapes;
    public TetrisWorld(Shapes user, LinkedList placedShapes, int x, int y, int dx, int dy) {
        this.user = user;
        this.placedShapes = placedShapes;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
    
    public void keyPressed(KeyEvent e){
    	int keyCode = e.getKeyCode();
    	switch(keyCode) {
    	case KeyEvent.VK_UP:
    		//check if it can move
    		
    	}
    }
 
    public static void main(String[] args) {
        WorldCanvas c = new WorldCanvas(wWidth, wHeight);
    }

    @Override
    public WorldImage makeImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
