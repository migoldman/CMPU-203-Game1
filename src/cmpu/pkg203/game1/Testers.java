/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpu.pkg203.game1;

import static cmpu.pkg203.game1.TetrisWorld.*;
import static cmpu.pkg203.game1.TetrisWorld.getHeight;
import static cmpu.pkg203.game1.TetrisWorld.makeBlock;
import static cmpu.pkg203.game1.TetrisWorld.random;
import static cmpu.pkg203.game1.TetrisWorld.randomInt;
import static cmpu.pkg203.game1.TetrisWorld.user;
import java.util.LinkedList;

/**
 *
 * @author michaelgoldman
 */
public class Testers {
    
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

    public Shapes randomShapes() {
        return new Shapes(randomShape(),randomRotation(),randomWidth(),randomHeight()); 
    }
    
    
    
    public static void main(String[] args) {

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


