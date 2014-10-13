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
import java.util.Random;
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
    Random random;
    int squareMatrix[][];
    //[type][rotation][x of grid][y of grid]
    int SHAPES[][][][] = {
    //This defines all the shapes, a matrix where 1 is
        //where blocks will be and 0 will be empty
           
        //TYPE
            //ROTATION
                //X AND Y
        
        //Square shaped
        {
            {
                //UP
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0}
            },
            {
                //LEFT
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0}
            },
            {
                //DOWN
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0}
            },
            {
                //RIGHT
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,0},
                {0,1,1,0}
            },
        },
        
        //S shape
        {
            {
                //UP
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,0},
                {1,1,0,0}
            }, 
            {
                //LEFT
                {0,0,0,0},
                {1,0,0,0},
                {1,1,0,0},
                {0,1,0,0}
            },
            {
                //DOWN
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,0},
                {1,1,0,0}
            }, 
            {
                //RIGHT
                {0,0,0,0},
                {1,0,0,0},
                {1,1,0,0},
                {0,1,0,0}
            },
        },
        
        //Line shape
        {
            {
                //UP
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
            },
            {
                //LEFT
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {1,1,1,1}
            },
            {
                //DOWN
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0},
                {1,0,0,0}
            },
            {
                //RIGHT
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {1,1,1,1}
            },
        },
        //T shape
        {
            {
                //UP
                {0,0,0,0},
                {0,0,0,0},
                {0,0,1,0},
                {0,1,1,1},
            },
            {
                //LEFT
                {0,0,0,0},
                {0,0,1,0},
                {0,1,1,0},
                {0,0,1,0}
            },
            {
                //DOWN
                {0,0,0,0},
                {0,0,0,0},
                {0,1,1,1},
                {0,0,1,0}
            },
            {
                //RIGHT
                {0,0,0,0},
                {0,0,1,0},
                {0,0,1,1},
                {0,0,1,0}
            }
        },
        //Z shape
        {
            {
                //UP
                {0,0,0,0}, 
                {0,0,0,0},
                {0,1,1,0},
                {0,0,1,1}
            },
            {
                //LEFT
                {0,0,0,0}, 
                {0,0,0,1},
                {0,0,1,1},
                {0,0,1,0}
            },
            {
                //DOWN
                {0,0,0,0}, 
                {0,0,0,0},
                {0,1,1,0},
                {0,0,1,1}
            },
            {
                //RIGHT
                {0,0,0,0}, 
                {0,0,0,1},
                {0,0,1,1},
                {0,0,1,0}
            },
        },
        //L shaped
        {
            {
                //UP
                {0,0,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,1,0},
            },
            {
                //LEFT
                {0,0,0,0},
                {0,0,0,0},
                {0,0,1,0},
                {1,1,1,0}
            },
            {
                //DOWN
                {0,0,0,0},
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0}
            },
            {
                //RIGHT
                {0,0,0,0},
                {0,0,0,0},
                {1,1,1,0},
                {1,0,0,0}
            },
        },
        //reverse L shaped
        {
            {
                //UP
                {0,0,0,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,1,1,0}
            },
            {
                //LEFT
                {0,0,0,0},
                {0,0,0,0},
                {1,1,1,0},
                {0,0,1,0}
            },
            {
                //DOWN
                {0,0,0,0},
                {0,1,1,0},
                {0,1,0,0},
                {0,1,0,0}
            },
            {
                //RIGHT
                {0,0,0,0},
                {0,0,0,0},
                {1,0,0,0},
                {1,1,1,0}
            }
        },
    };
    
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
                throw new NullPointerException();
                
        }
    }
    
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
                throw new NullPointerException();
        }
    }
    
    public int[][] getMatrix() {
        Shapes temp = new Shapes(this.block,this.orientation,this.x,this.y);
        return SHAPES[temp.getType()][temp.getOrientation()];
    }
    
    //will check if the location in the matrix should be a block
    public boolean isBlockHuh(int xM, int yM) {
        Shapes temp = new Shapes(this.block, this.orientation, this.x, this.y);
        return temp.getMatrix()[xM][yM] == 1;
    }

    public Shapes setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return new Shapes(block, this.orientation, x, y);
    }
    
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
    
    //makes a random int 1-7 for block types
    public int randomInt() {
        return random.nextInt((0 - 6) + 1) + 0;
    }
          
    public Shapes makeBlock(int number){
        switch(number) {
        	case 1:
                    return new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 0);
        	case 2:
                    return new Shapes(ShapeType.S, Rotation.UP, 5, 0);
        	case 3:
                    return new Shapes(ShapeType.LINE, Rotation.UP, 5, 0);
        	case 4:
                    return new Shapes(ShapeType.T, Rotation.UP, 5, 0);
        	case 5:
                    return new Shapes(ShapeType.Z, Rotation.UP, 5, 0);
        	case 6:
                    return new Shapes(ShapeType.L, Rotation.UP, 5, 0);
    		default:
                    return new Shapes(ShapeType.rL, Rotation.UP, 5, 0);
        }
    }
}
    
