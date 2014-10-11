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

public class Shapes {
    int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3; 
    final int side = 10;
    int type, x, y;
    Shapes block;
    Random random;
    int orientation;
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
    public Shapes(int type, int orientation, int[][] squareMatrix, int x, int y) {
        this.squareMatrix = squareMatrix;
        this.orientation = orientation;
        this.x = x;
        this.y = y;
    }
    
    public int getType() {
        return this.type;
    }
    
    public int getOrientation() {
        return this.orientation;
    }
    
    public int[][] getMatrix() {
        return this.squareMatrix;
    }
    
    //will check if the location in the matrix should be a block
    public boolean isBlockHuh(int x, int y) {
        return squareMatrix[x][y] == 1;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public Shapes setPos(int x, int y) {
        this.x = x;
        this.y = y;
        return new Shapes(this.type, this.orientation, this.squareMatrix, x, y);
    }
    
    public Shapes rotate() {
        int rotation = this.orientation;
        Shapes temp;
        switch(rotation) {
            case 0:
                squareMatrix=SHAPES[type][1];
                temp = new Shapes(this.type,1,squareMatrix,this.x,this.y);
                break;
            case 1:
                squareMatrix=SHAPES[type][2];
                temp = new Shapes(this.type,2,squareMatrix,this.x,this.y);
                break;
            case 2:
                squareMatrix=SHAPES[type][3];
                temp = new Shapes(this.type,3,squareMatrix,this.x,this.y);
                break;
            default:
                squareMatrix=SHAPES[type][0];
                temp = new Shapes(this.type,0,squareMatrix,this.x,this.y);
        }
        return temp;
    }  
    
    //makes a random int 1-7 for block types
    public int randomInt() {
        return random.nextInt((0 - 6) + 1) + 0;
    }
          
    public Shapes makeBlock(){
        int randInt = randomInt();
        int[][] temp = squareMatrix;
        switch(randInt) {
        	case 1:
        		temp = SHAPES[0][0];
        		break;
        	case 2:
    			temp = SHAPES[1][0];
    			break;
        	case 3:
        		temp = SHAPES[2][0];
        		break;
        	case 4:
        		temp = SHAPES[3][0];
        		break;
        	case 5:
        		temp = SHAPES[4][0];
        		break;
        	case 6:
        		temp = SHAPES[5][0];
        		break;
    		default:
                        temp = SHAPES[6][0];
                        break;
        }
        return new Shapes(randInt, 0, temp, 5, 0);
    }
}
    
