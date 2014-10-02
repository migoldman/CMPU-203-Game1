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

import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import java.awt.*;
import java.util.Random;

public class Shapes {
    
    int side;
    int type;
    Posn position;
    Color color;
    Random randInt;
    boolean b_Shapes[][][] = {
        {//This defines all the shapes, a matrix where true is
            //where blocks will be and false will be empty
            
            //z shape
            {false,false,false,false},
            {false,false,false,false},
            {false,true,true, false},
            {false,false,true,true}
        },
        {
            //s shape
            {false,false,false,false},
            {false,false,false,false},
            {false, true, true, false},
            {true, true, false, false}
        },
        {
            //line shape
            {true,false,false,false},
            {true,false,false,false},
            {true,false,false,false},
            {true,false,false,false},
        },
        {
            //T shaped
            {false,false,false,false},
            {false,false,false,false},
            {false, true, true, true},
            {false,false,true,false},
        },
        {
            //Square shaped
            {false,false,false,false},
            {false,false,false,false},
            {false,true,true,false},
            {false,true,true,false},
        },
        {
            //L shaped
            {false,false,false,false},
            {false,true,false,false},
            {false, true,false,false},
            {false,true,true,false},
        },
        {
            //reverse L shaped
            {false,false,false,false},
            {false,false,true,false},
            {false,false,true,false},
            {false,true,true,false},
        },
    };
    
    public Shapes(Posn position, Color color, int side, int type) {
        this.position = position;
        this.color = color;
        this.side = side;
        this.type = type;
    }
    
    //makes a random int 1-7 for block types
    public int randBlock() {
        return randInt.nextInt((0 - 6) + 1) + 0;
    }    
    
    public Shapes blockType(int type) {
        int randBlock = randBlock();
        
    }

    

    
    
}
