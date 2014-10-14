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
enum Rotation {
    UP, LEFT, RIGHT, DOWN;
}
enum ShapeType {
    SQUARE, S, LINE, T, Z, L, rL; 
}
public class Shapes {
    final int side = 10;
    int x, y;
    ShapeType block;
    Rotation orientation;
    
    //What is in a shape
        //Has the type of shape it is
        //Has the orientation of the shape
        //Has a shape (based on x and y location in the  matrix)
        //Has a x position and a y position in the world grid
    public Shapes(ShapeType block, Rotation orientation, int x, int y) {
        this.block = block;
        this.orientation = orientation;
        this.x = x;
        this.y = y;
    }
    
    //Gives you an int representing the type of block it is
    public int getType() {
        ShapeType temp = block;
        switch (temp) {
            case SQUARE:
                return 0;
            case S:
                return 1;
            case LINE:
                return 2;
            case T:
                return 3;
            case Z:
                return 4;
            case L:
                return 5;
            case rL:
                return 6;
            default:
                throw new RuntimeException("TYPE IS WRONG");
                
        }
    }
    
    //Gives you an int representing the orientation the block has
    public int getOrientation() {
        Rotation rotation = orientation;
        switch(rotation) {
            case UP:
                return 0;
            case LEFT: 
                return 1;
            case DOWN:
                return 2;
            case RIGHT:
                return 3;
            default:
                throw new RuntimeException("Orientation isn't work");
        }
    }
    
    //Gives you a new position for the block
    public Shapes setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return new Shapes(block, this.orientation, x, y);
    }
    
    //Rotates the block
    public Shapes rotate() {
        Rotation rotation = orientation;
        Shapes temp;
        switch(rotation) {
            case UP:
                temp = new Shapes(this.block,Rotation.LEFT,this.x,this.y);
                break;
            case LEFT:
                temp = new Shapes(this.block,Rotation.DOWN,this.x,this.y);
                break;
            case DOWN:
                temp = new Shapes(this.block,Rotation.RIGHT,this.x,this.y);
                break;
            default:
                temp = new Shapes(this.block,Rotation.UP,this.x,this.y);
        }
        return temp;
    }

}