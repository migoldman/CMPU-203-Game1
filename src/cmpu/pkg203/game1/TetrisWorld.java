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


import javalib.funworld.*;
import javalib.colors.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;

public class TetrisWorld extends World{
    
    static final int rows = 20;
    static final int columns = 10;
    static final int screenWidth = columns*300;
    static final int screenHeight = rows*300;
    static int[][] worldArray;
    static Random random;
    
    static final int S = 30;
    
    static int frames;
    
    static Shapes user;
    static LinkedList<Shapes> placedShapes;
    static TetrisWorld world;

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
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //LEFT
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //DOWN
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //RIGHT
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },},
        //S shape
        {
            {
                //UP
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                
            },
            {
                //LEFT
                
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //DOWN
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //RIGHT
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},

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
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                
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
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },},
        //T shape
        {
            {
                //UP
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                
            },
            {
                //LEFT
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},

            },
            {
                //DOWN
                
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //RIGHT
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},

            }
        },
        //Z shape
        {
            {
                //UP
                
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //LEFT
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},

            },
            {
                //DOWN
                
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //RIGHT
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},

            },},
        //L shaped
        {
            {
                //UP
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},

            },
            {
                //LEFT
                
                {0, 0, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //DOWN
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //RIGHT
                
                {1, 1, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },},
        //reverse L shaped
        {
            {
                //UP
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //LEFT
                
                {1, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //DOWN
                {1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
            },
            {
                //RIGHT
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
            }
        },};


    public TetrisWorld() {
        this.user = new Shapes(ShapeType.SQUARE,Rotation.UP,5,0);
        this.placedShapes = new LinkedList<Shapes>();
        this.frames = 0;
    }
    
    public TetrisWorld(Shapes user, LinkedList<Shapes> placedShapes) {
        super();
        this.user = user;
        this.placedShapes = placedShapes;
    }



    //makes a random int 1-7 for block types
    public static int randomInt() {
        return random.nextInt((7 - 1) + 1) + 1;
    }

    //makes a block of a certain type (based on number) in the top middle
    public static Shapes makeBlock(int number) {
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

    //gets the matrix of the shape type and orientation
    public int[][] getMatrix(Shapes user) {
        return SHAPES[user.getType()][user.getOrientation()];
    }
    
    //Checks if there is a floor below the block or a placed one
    public boolean blockBelowHuh(Shapes user) {
        boolean badMove = false;
        for (Shapes temp : placedShapes) {
            for(int ucol = 0; ucol < 4; ucol++) {
                for(int urow = 0; urow < 4; urow++) {
                    for(int pcol = 0; pcol < 4; pcol++) {
                        for(int prow = 0; prow < 4; prow++) {
                            badMove |= ((user.y + urow + 1) == (temp.y + prow)
                                    && ((user.x + ucol) == (temp.x + pcol))
                                    && (getMatrix(user)[ucol][urow]) ==1
                                        && (getMatrix(temp)[pcol][prow] == 1));
                        }
                    }
                    if(user.y + getHeight(user) >= 20) {
                        badMove = true;
                    }
                }
            }
        }
        return badMove;
    }
    
    //Checks if a block is on the left, if it is going into the left wall, or floor
    public boolean blockOnLeftHuh(Shapes user) {
        boolean badMove = false;
        for (Shapes temp : placedShapes) {
            for(int ucol = 0; ucol < 4; ucol++) {
                for(int urow = 0; urow < 4; urow++) {
                    for(int pcol = 0; pcol < 4; pcol++) {
                        for(int prow = 0; prow < 4; prow++) {
                            badMove |= ((user.y + urow) == (temp.y + prow)
                                    && ((user.x + ucol - 1) == (temp.x + pcol))
                                    && (getMatrix(user)[ucol][urow]) ==1
                                        && (getMatrix(temp)[pcol][prow] == 1));
                        }
                    }
                    if(0 > user.x || user.y + urow >= 20) {
                        badMove = true;
                    }
                }
            }
        }
        return badMove;
    }
    
    //Checks if a block is on the right, if it is going into the right wall, or floor
    public boolean blockOnRightHuh(Shapes user) {
        boolean badMove = false;
        for (Shapes temp : placedShapes) {
            
            for(int ucol = 0; ucol < 4; ucol++) {
                for(int urow = 0; urow < 4; urow++) {
                    for(int pcol = 0; pcol < 4; pcol++) {
                        for(int prow = 0; prow < 4; prow++) {
                            badMove |= ((user.y + urow) == (temp.y + prow)
                                    && ((user.x + ucol + 1) == (temp.x + pcol))
                                    && (getMatrix(user)[ucol][urow]) ==1
                                        && (getMatrix(temp)[pcol][prow] == 1));
                        }
                    }
                    if(user.x + getWidth(user) >= 10 || user.y + urow >= 20) {
                        badMove = true;
                    }
                }
            }
        }
        return badMove;
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
    
    //If there is a block on the left or right or if it is too close to an
        //edge after the rotation, do return false, else true;
            //Might potentially lead to trouble, unsure
    public boolean canRotate(Shapes block) {
        Shapes rotatedB = block.rotate();
        if(blockOnRightHuh(rotatedB) 
                || blockOnLeftHuh(rotatedB) 
                || getWidth(rotatedB) + rotatedB.x > 10 
                || getWidth(rotatedB) + rotatedB.x < 0) {
            return false;
        }
        return true;
    }
    
    
    public TetrisWorld keyPressed(String ke) {
        TetrisWorld temp;
        int x = user.x;
        int y = user.y;
        int newY = y + 1; 
        //Block is always moving down, while can move left or right with x
        switch (ke) {
            case ("left"):
                if (blockOnLeftHuh(user)) {
                    temp = new TetrisWorld(this.user.setPos(x - 1, newY), this.placedShapes);
                } else {
                    temp = new TetrisWorld(this.user.setPos(x, newY), this.placedShapes);
                }
                break;
            case ("right"):
                if (blockOnRightHuh(user)) {
                    temp = new TetrisWorld(this.user.setPos(x + 1, newY), this.placedShapes);
                } else {
                    temp = new TetrisWorld(this.user.setPos(x, newY), this.placedShapes);
                }
                break;
            case ("up"):
                if(canRotate(user)) {
                    temp = new TetrisWorld(this.user.rotate(), this.placedShapes);
                    break;
                }
            default:
                temp = new TetrisWorld(this.user.setPos(user.x, newY), placedShapes);
        }
        return temp;
    }
    
    
    ///////WORLD STUFF
    
    public WorldImage background() {
        return new RectangleImage(new Posn(screenWidth/2, screenHeight/2), 
                screenWidth, screenHeight,new Black());
    }
    
    //This is just silly
    public WorldImage blockDraw(int x, int y) {
        return new RectangleImage(new Posn(x, y), S, S, new Red());
    }
    public WorldImage shapeDraw(int x1, int y1, int x2, int y2,
                                    int x3, int y3, int x4, int y4) {
        return new OverlayImages(background(), 
                new OverlayImages(blockDraw(x1,y1),
                new OverlayImages(blockDraw(x2,y2),
                new OverlayImages(blockDraw(x3,y3), 
                        blockDraw(x4,y4)))));
    }
    //I really hope there is a better way to do this so I don't ever have to do this again
    public WorldImage blockImages(Shapes block) {
        int XPOS = user.x;
        int YPOS = user.y+4; 
            //thrid row on the grid 
            //(since it is all bottom left oriented)
        int orientation = block.getOrientation();
        switch(block.getType()) {
            case 1:
                shapeDraw(XPOS*S,YPOS*S,
                        XPOS++*S,YPOS++*S,
                        XPOS*S,YPOS++*S,
                        XPOS++*S,YPOS++*S);
            case 2://S
                switch(orientation) {
                    case 0:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                (2+XPOS)*S,YPOS*S);
                    case 1:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS++*S,
                                XPOS++*S,(2+YPOS)*S);
                    case 2:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                (2+XPOS)*S,YPOS*S);
                    case 3:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS++*S,
                                XPOS++*S,(2+YPOS)*S);
                }
            case 3://Line
                switch(orientation) {
                    case 0:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS*S,(2+YPOS)*S,
                                XPOS*S,(3+YPOS)*S);
                    case 1:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                (2+XPOS)*S,YPOS*S,
                                (3+XPOS)*S,YPOS*S);
                    case 2:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS*S,(2+YPOS)*S,
                                XPOS*S,(3+YPOS)*S);
                    case 3:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                (2+XPOS)*S,YPOS*S,
                                (3+XPOS)*S,YPOS*S);
                }
            case 4:
                switch(orientation) {
                    case 0:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                (XPOS+2)*S,YPOS++*S);
                    case 1:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                XPOS++*S,(YPOS+2)*S);
                    case 2:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                (XPOS+2)*S,YPOS*S);
                    case 3:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS*S,(YPOS+2)*S,
                                XPOS++*S,YPOS++*S);
                }
            case 5:
                switch(orientation) {
                    case 0:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                (2+XPOS)*S,YPOS++*S);
                    case 1:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS*S,(YPOS+2)*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S);
                    case 2:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                (XPOS+2)*S,YPOS++*S);
                    case 3:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS*S,(YPOS+2)*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S);
                }
            case 6:
                switch(orientation) {
                    case 0:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS*S,(YPOS+2)*S,
                                XPOS++*S,(YPOS+2)*S);
                    case 1:
                        shapeDraw(XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS++*S,
                                (2+XPOS)*S,YPOS++*S,
                                (2+XPOS)*S,YPOS*S);
                    case 2:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                XPOS++*S,(2+YPOS)*S);
                    case 3:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS++*S,
                                (XPOS+2)*S,YPOS++*S);
                }
            case 7:
                switch(orientation) {
                    case 0:
                        shapeDraw(XPOS*S,(2+YPOS)*S,
                                XPOS++*S,YPOS*S,
                                XPOS++*S,YPOS++*S,
                                XPOS++*S,(2+YPOS)*S);
                    case 1:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS++*S,YPOS*S,
                                (XPOS+2)*S,YPOS*S,
                                (XPOS+2)*S,YPOS++*S);
                    case 2:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS*S,(2+YPOS)*S,
                                XPOS++*S,YPOS++*S);
                    case 3:
                        shapeDraw(XPOS*S,YPOS*S,
                                XPOS*S,YPOS++*S,
                                XPOS++*S,YPOS++*S,
                                (2+XPOS)*S,YPOS++*S);
                }
            default:
               return shapeDraw(XPOS*S,YPOS*S,
                        XPOS++*S,YPOS++*S,
                        XPOS*S,YPOS++*S,
                        XPOS++*S,YPOS++*S);
        }
                    
    }
    
    
    public WorldImage placedImages(LinkedList<Shapes> placedShapes, int counter) {
        WorldImage temp;
        if(placedShapes.isEmpty()) {
            temp = blockImages(user);
        }
        else if(counter ==-1) {
            temp = blockImages(user);
        }
        else { 
            temp = new OverlayImages(placedImages(placedShapes,counter-1),
                blockImages(placedShapes.get(counter)));
        }
        return temp;
    }
    
    public WorldImage drawScore() {
        return new TextImage(new Posn(screenWidth/2,screenHeight-30),
        "Score: " + placedShapes.size(), 8, new White());
    }
    
    public WorldImage makeImage() {
        return new OverlayImages((placedImages(placedShapes, placedShapes.size()-1)),
                new OverlayImages(blockImages(user), drawScore()));
    }
    
    public TetrisWorld tick() {
        if(blockBelowHuh(user)) {
            placedShapes.add(new Shapes(user.block,user.orientation,user.x,user.y));
            return new TetrisWorld(makeBlock(randomInt()),placedShapes);
        }
        else if(blockOnLeftHuh(user)){
            user.x = 0;
            return new TetrisWorld(user,placedShapes);
        }
        else if(blockOnRightHuh(user)){
            user.x = columns-getWidth(user);
            return new TetrisWorld(user,placedShapes);
        }
        else {
            return new TetrisWorld(user,placedShapes);
        }
    }
    

    //Game over
    public boolean gameOver() {
        return blockBelowHuh(makeBlock(randomInt()));
        }
    
    public WorldEnd loseScreen() {
        if(gameOver()) {
             return new WorldEnd(true, new OverlayImages(this.makeImage(),
                    new TextImage(new Posn(screenWidth/2,screenHeight/2), 
                            ("Game Over: You've reached level " + placedShapes.size()), 
                            20, new White())));
        }
        else return new WorldEnd(false, this.makeImage());
    }
    
    public static void main(String[] args) {
        TetrisWorld game = new TetrisWorld();
        game.bigBang(300, 600, 1);
    }
}
