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
import java.util.Random;

enum Rotation{
    left, right, up, down;
}

public class Shapes {
    Rotation left, right, up, down;
    int side, type, x, y;
    Random random;
    Shapes block;
    Rotation orientation;
    int b_Shapes[][][] = {
        {//This defines all the shapes, a matrix where 1 is
            //where blocks will be and 0 will be empty
            //All orientations are up
            
            //Square shaped
            {0,0,0,0},
            {0,0,0,0},
            {0,1,1,0},
            {0,1,1,0},
        },
        {
            //s shape
            {0,0,0,0},
            {0,0,0,0},
            {0,1,1,0},
            {1,1,0,0}
        },
        {
            //line shape
            {1,0,0,0},
            {1,0,0,0},
            {1,0,0,0},
            {1,0,0,0},
        },
        {
            //T shaped
            {0,0,0,0},
            {0,0,0,0},
            {0,1,1,1},
            {0,0,1,0},
        },
        {
            //z shape
            {0,0,0,0},
            {0,0,0,0},
            {0,1,1,0},
            {0,0,1,1}
        },
        {
            //L shaped
            {0,0,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,1,0},
        },
        {
            //reverse L shaped
            {0,0,0,0},
            {0,0,1,0},
            {0,0,1,0},
            {0,1,1,0},
        },
    };
    //this matrix is
    public Shapes(Rotation orientation, int type, int x, int y) {
        this.block = block;
        this.orientation = orientation;
        this.type = type;
        this.x = x;
        this.y = y;
    }
    
    public Shapes getShapes() {
        return this.block;
    }
    
    
    public Rotation getOrientation() {
        return this.orientation;
    }
    
    public int getType() {
        return this.type;
    }
    
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    
    public Shapes rotate() {
        if(this.block.getOrientation().equals(up)) {
            return new Shapes(left, this.type, this.x, this.y);
        }
        if(this.block.getOrientation().equals(left)) {
            return new Shapes(down, this.type, this.x, this.y);
        }
        if(this.block.getOrientation().equals(down)) {
            return new Shapes(right, this.type, this.x, this.y);
        }
        else {
            return new Shapes(up, this.type, this.x,this.y);
        }
    }
    
    //makes a random int 1-7 for block types
    public int randInt() {
        return random.nextInt((0 - 6) + 1) + 0;
    }     
    
    public Shapes makeBlock(){
        int randInt = randInt();
        if(randInt == 1) {
            return 
        }
    }
}