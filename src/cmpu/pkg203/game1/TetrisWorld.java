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
import java.util.LinkedList;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;

public class TetrisWorld {
    
    static final int rows = 20;
    static final int columns = 10;
    static int[][] worldArray;
    Random random;
    int dx;
    int dy;
    Shapes user;
    LinkedList<Shapes> placedShapes;
    TetrisWorld world;

    static final int SHAPES[][][][] = {
        //This defines all the shapes, a matrix where 1 is
        //where blocks will be and 0 will be empty

        //TYPE
        //ROTATION
        //X AND Y

        //Square shaped
        {
            {
                //UP
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
            },
            {
                //LEFT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
            },
            {
                //DOWN
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
            },},
        //S shape
        {
            {
                //UP
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 0}
            },
            {
                //LEFT
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
            },
            {
                //DOWN
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {1, 1, 0, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
            },},
        //Line shape
        {
            {
                //UP
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
            },
            {
                //LEFT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
            },
            {
                //DOWN
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1}
            },},
        //T shape
        {
            {
                //UP
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 1, 0},},
            {
                //LEFT
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0}
            },
            {
                //DOWN
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
            }
        },
        //Z shape
        {
            {
                //UP
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
            },
            {
                //LEFT
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
            },
            {
                //DOWN
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
            },},
        //L shaped
        {
            {
                //UP
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
            },
            {
                //LEFT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 1, 1, 0}
            },
            {
                //DOWN
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 0, 0, 0}
            },},
        //reverse L shaped
        {
            {
                //UP
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 1, 0}
            },
            {
                //LEFT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 1, 0}
            },
            {
                //DOWN
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
            },
            {
                //RIGHT
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 1, 0}
            }
        },};

    //Make the world a dense matrix of falses, then add in graphics
    public TetrisWorld(Shapes user, LinkedList<Shapes> placedShapes) {
        this.user = user;
        this.placedShapes = placedShapes;
    }

    //Makes an empty world (and a random spawn piece at top middle)
    public TetrisWorld newWorld() {
        return new TetrisWorld(makeBlock(randomInt()), new LinkedList());
    }

    //makes a random int 1-7 for block types
    public int randomInt() {
        return random.nextInt((7 - 1) + 1) + 1;
    }

    //makes a block of a certain type (based on number) in the top middle
    public Shapes makeBlock(int number) {
        switch (number) {
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

    //maybed not needed, not sure (afraid to delete in case I do need it)
    public int[][] getMatrix() {
        Shapes temp = new Shapes(user.block, user.orientation, user.x, user.y);
        return SHAPES[temp.getType()][temp.getOrientation()];
    }

    //same as above
    public boolean isBlockHuh(int xM, int yM) {
        //this is bad coding. Will hopefully fix
        world = new TetrisWorld(this.user, this.placedShapes);
        return world.getMatrix()[xM][yM] == 1;
    }

    //Checks:
        //if the block is right above a placed block
            //aka their x pos is the same and the 
            //y pos of the user is one less than the placed one
        //OR if the y pos of the block is at the bottom (this might lead to problems with tick)
    public boolean aboveBlockHuh() {
        int xPos = user.x;
        int yPos = user.y;
        for (Shapes placedShape : placedShapes) {
            if (yPos + 1 == placedShape.y && xPos == placedShape.x) {
                return true;
            }
        }
        if (yPos >= 20) {
            return true;
        } else {
            return false;
        }
    }
    
    //The max widths of all the blocks and all their orientations
    public int getWidth(Shapes block) {
        int type = block.getType();
        int orientation = block.getOrientation();
        switch(type) {
            case 0: // square
                return 2;
            case 1: //s
                switch(orientation) {
                    case 0:
                        return 3;
                    case 1:
                        return 2; 
                    case 2:
                        return 3;
                    case 3:
                        return 2;
            }
            case 2: //line
                switch(orientation) {
                    case 0:
                        return 1;
                    case 1:
                        return 4;
                    case 2:
                        return 1;
                    case 3:
                        return 4;
            }
            case 3: //t
                switch(orientation) {
                    case 0:
                        return 3;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 2;
            }
            case 4: //z
                switch(orientation) {
                    case 0:
                        return 3;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 2;
            }
            case 5: //l
                switch(orientation) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
            }
            case 6: //rl
                switch(orientation) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
            }
            default:
                throw new RuntimeException("AAAGGGHHHHH (width is wrong)");
        }
    }
    
    //The max heights of all the blocks and all their orientations
    public int getHeight(Shapes block) {
        int type = block.getType();
        int orientation = block.getOrientation();
        switch(type) {
            case 0:
                return 2;
            case 1:
                switch(orientation) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                }
            case 2:
                switch(orientation) {
                    case 0:
                        return 4;
                    case 1:
                        return 1;
                    case 2:
                        return 4;
                    case 3:
                        return 1;
                }
            case 3:
                switch(orientation) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                }
            case 4:
                switch(orientation) {
                    case 0:
                        return 2;
                    case 1:
                        return 3;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                }
            case 5:
                switch(orientation) {
                    case 0:
                        return 3;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 2;
                }
            case 6:
                switch(orientation) {
                    case 0:
                        return 3;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 2;
                }
            default:
                throw new RuntimeException("this is what true sadness is (height is wrong)");
        }
    }
    
//Used with rotation
    //checks if if the location of a current block if valid compared to a placed one
        //This might need work since I don't think it will work with only by comparing it to one block
    public boolean isValidHuh(Shapes block) {
        int xPos = block.x;
        int yPos = block.y;
        for (Shapes placedShape : placedShapes) {
            if (yPos == placedShape.y && xPos == placedShape.x) {
                return false;
            }
        }
        if(block.x + getHeight(block) >= 20) {
            
        }
        if()
        return true;
    }
    
    
    //Think it is good
    public TetrisWorld keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        TetrisWorld temp;
        int x = user.x;
        int y = user.y;
        int newY = y + 1; 
        //Block is always moving down, while can move left or right with x
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (x-1 >= 0) {
                    temp = new TetrisWorld(this.user.setPos(x - 1, newY), this.placedShapes);
                } else {
                    temp = new TetrisWorld(this.user.setPos(x, newY), this.placedShapes);
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (x+1 <= columns) {
                    temp = new TetrisWorld(this.user.setPos(x + 1, newY), this.placedShapes);
                } else {
                    temp = new TetrisWorld(this.user.setPos(x, newY), this.placedShapes);
                }
                break;
            case KeyEvent.VK_UP:
                if(isValidHuh(user.rotate())) {
                    temp = new TetrisWorld(this.user.rotate(), this.placedShapes);
                    break;
                }
            default:
                temp = new TetrisWorld(this.user.setPos(user.x, newY), placedShapes);
        }
        return temp;
    }

    public TetrisWorld tick() {
        
    }
}
