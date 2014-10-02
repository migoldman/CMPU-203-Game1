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
    public WorldImage world;
    Shapes block;
    
    public TetrisWorld() {
        
    }
    
    public void keyPressed(KeyEvent e){
    }
    
    
    
    public static void main(String[] args) {
        WorldCanvas c = new WorldCanvas(wWidth, wHeight);
    }

    @Override
    public WorldImage makeImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
