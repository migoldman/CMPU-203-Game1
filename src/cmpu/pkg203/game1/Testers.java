/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpu.pkg203.game1;

import static cmpu.pkg203.game1.TetrisWorld.getHeight;
import static cmpu.pkg203.game1.TetrisWorld.makeBlock;
import static cmpu.pkg203.game1.TetrisWorld.random;
import static cmpu.pkg203.game1.TetrisWorld.randomInt;
import static cmpu.pkg203.game1.TetrisWorld.user;
import static cmpu.pkg203.game1.TetrisWorld.placedShapes;
import java.util.LinkedList;

/**
 *
 * @author michaelgoldman
 */
public class Testers extends TetrisWorld{
    
    public static LinkedList<Shapes> MT = new LinkedList<Shapes>();
    
    public static int randomHeight() {
        return random.nextInt((19 - 0) + 0) + 1;
    }
    public static int randomWidth() {
        return random.nextInt((10 - 0) + 0) + 1;
    }
    public static ShapeType randomShape() {
        int temp = random.nextInt((7 - 1) + 1) + 1;
        ShapeType type = ShapeType.S;
        switch(temp) {
            case 1:
                type = ShapeType.L;
                break;
            case 2:
                type = ShapeType.LINE;
                break;
            case 3:
                type = ShapeType.S;
                break;
            case 4:
                type = ShapeType.SQUARE;
                break;
            case 5:
                type = ShapeType.T;
                break;
            case 6:
                type = ShapeType.Z;
                break;
            case 7:
                type = ShapeType.rL;
        }
        return type;
    }
    public static Rotation randomRotation() {
        int temp = random.nextInt((4-1)+1)+1;
        Rotation rotate = Rotation.UP;
        switch(temp) {
            case 1:
                rotate = Rotation.UP;
                break;
            case 2:
                rotate = Rotation.LEFT;
                break;
            case 3:
                rotate = Rotation.DOWN;
                break;
            case 4:
                rotate = Rotation.RIGHT;
        }
        return rotate;
    }

    //make a random shape
    public static Shapes randomShapes() {
        return new Shapes(randomShape(),randomRotation(),randomWidth(),randomHeight()); 
    }
    
    //make a random list of dead items that don't take up the same point
    public static LinkedList<Shapes> randomPlaced(int size) {
        LinkedList<Shapes> placed = new LinkedList<Shapes>();
        placed.add(new Shapes(ShapeType.S,Rotation.UP, 100, 100));
        //an impossible block
        for(int i = 0; i < size; i++) {
            Shapes shape = randomShapes();
            for(int j = 0; j< placed.size(); j++) {
                if(shape.x != placed.get(j).x && shape.y != placed.get(j).y) {
                    placed.add(shape);
                }
            }
        }
        return placed;
    }
    
    public static TetrisWorld testWorld(Shapes user, LinkedList<Shapes> placed) {
        return new TetrisWorld(user, placed);
    }
    
    
    public static void movedLeft() {
        Shapes user = randomShapes();
        TetrisWorld beforeMT = testWorld(user,MT);
        TetrisWorld afterMT = testWorld(user,MT).onKeyEvent("left");
        TetrisWorld before = testWorld(user,randomPlaced(randomInt()));
        TetrisWorld after = testWorld(user,randomPlaced(randomInt())).onKeyEvent("left");
        if(afterMT.user.x < 0) {
            System.out.println("Moved through left wall");
        }
        if(afterMT.user.x == beforeMT.user.x && beforeMT.user.x >0 && beforeMT.user.x <9 && beforeMT.user.y > 15) {
            System.out.println("Didn't move");
        }
        for(int i = 0; i < after.placedShapes.size(); i ++) {
            if(after.user.x == placedShapes.get(i).x && after.user.y == placedShapes.get(i).y) {
               System.out.println("Moved into block");
            }
        }
    }
    
    public static void movedRight() {
        Shapes user = randomShapes();
        TetrisWorld beforeMT = testWorld(user,MT);
        TetrisWorld afterMT = testWorld(user,MT).onKeyEvent("right");
        TetrisWorld before = testWorld(user,randomPlaced(randomInt()));
        TetrisWorld after = testWorld(user,randomPlaced(randomInt())).onKeyEvent("right");
        if(afterMT.user.x + getWidth(afterMT.user) > 10) {
            System.out.println("Moved through right wall");
        }
        if(afterMT.user.x == beforeMT.user.x && beforeMT.user.x >0 && beforeMT.user.x + getWidth(beforeMT.user)<10 && beforeMT.user.y > 15) {
            System.out.println("Didn't move");
        }
        for(int i = 0; i < after.placedShapes.size(); i ++) {
            if(after.user.x == placedShapes.get(i).x && after.user.y == placedShapes.get(i).y) {
               System.out.println("Moved into block");
            }
        }
    }
    
    public static void testStart(){
        if(newWorld().placedShapes.size() != 0 || frames != 0) {
            throw new RuntimeException("Error with test start");
        }
        
        if(gameOver == true) {
            throw new RuntimeException("Error with over");
        }
        
        if(newWorld().user.orientation != Rotation.UP) {
            throw new RuntimeException("Should be UP");
        }
        if(newWorld().user.x != 5 || newWorld().user.y != 0) {
            throw new RuntimeException("Wrong coordinates on user");
        }
    }
    
    public static String autoRun() {
        
    }
    
    public static void belowBottom() {
        
    }
    
    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
            testStart();
            movedLeft();
            movedRight();
        }

        //TESTERS
        TetrisWorld lWall = new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,0,0),new LinkedList<Shapes>());
        TetrisWorld rWall = new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,8,5),new LinkedList<Shapes>());
        
        Shapes square = new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 0);
        LinkedList<Shapes> MT = new LinkedList<Shapes>();
        LinkedList<Shapes> stackTest = new LinkedList<Shapes>();
        stackTest.add(new Shapes(ShapeType.SQUARE, Rotation.UP, 16, 5));

        System.out.println("random number: " + randomInt());

        System.out.println("Height of [0][0] " + getHeight(square));
        System.out.println("lWall.");
        System.out.println("Get Type returned a square to be " + makeBlock(1).getType() + " should be 0");
        System.out.println("Get Type returned a S to be " + makeBlock(2).getType() + " should be 1");
        System.out.println("Get Type returned a line to be " + makeBlock(3).getType() + " should be 2");
        System.out.println("Get Type returned a t to be " + makeBlock(4).getType() + " should be 3");
        System.out.println("Get Type returned a z to be " + makeBlock(5).getType() + " should be 4");
        System.out.println("Get Type returned a l to be " + makeBlock(6).getType() + " should be 5");
        System.out.println("Get Type returned a rl to be " + makeBlock(7).getType() + " should be 6");
        //System.out.println("Get Type random is " + makeBlock(randomInt()).getType());*/

        System.out.println("Block on block has block below true = " + new TetrisWorld(new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 16), stackTest).blockBelow(user, stackTest));
        System.out.println("Block on block has block below true = " + new TetrisWorld(new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 18), stackTest).blockBelow(user, stackTest));

        System.out.println("Block on floor has floor below true = "
                + new TetrisWorld(new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 18), MT).onFloorHuh());

         
         /*System.out.println("Block next to Lwall has block on right false =" + 
         new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,0,5),new LinkedList<Shapes>()).blockOnRight(user, placedShapes));
         System.out.println("Block next to Rwall has block on right true =" + 
         new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,8,5),new LinkedList<Shapes>()).blockOnRight(user, placedShapes));
         System.out.println("Block next to Rwall has block on left  false = " + 
         new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,8,5),new LinkedList<Shapes>()).blockOnLeft(user,placedShapes));*/
        TetrisWorld game = new TetrisWorld();
        game.bigBang(300, 600, 1);
    }
}


