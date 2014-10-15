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
import static cmpu.pkg203.game1.TetrisWorld.getMatrix;
import static cmpu.pkg203.game1.TetrisWorld.SHAPES;
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
    
    
    public static void movedLeftMT() {
        Shapes user = randomShapes();
        TetrisWorld beforeMT = testWorld(user,MT);
        TetrisWorld afterMT = testWorld(user,MT).onKeyEvent("left");
        if(afterMT.user.x < 0) {
            System.out.println("Moved through left wall");
        }
        if(afterMT.user.x > beforeMT.user.x) {
            System.out.println("moved right on a left");
        }
        if(afterMT.user.x == beforeMT.user.x && beforeMT.user.x !=0 && beforeMT.user.x <8 && (beforeMT.user.y < 4 && beforeMT.user.y > 16)) {
            System.out.println("Didn't move L");
        }
        if(afterMT.user.y < beforeMT.user.y) {
            System.out.println("YOU MOVED UP?!");
        }
        
    }
    
    public static void movedRightMT() {
        Shapes user = randomShapes();
        TetrisWorld beforeMT = testWorld(user,MT);
        TetrisWorld afterMT = testWorld(user,MT).onKeyEvent("right");
        if((afterMT.user.x > beforeMT.user.x) && (afterMT.user.x + getWidth(afterMT.user) > 10)) {
            System.out.println("Moved through right wall");
        }
        if(afterMT.user.x < beforeMT.user.x) {
            System.out.println("moved left on a right");
        }
        //have it slightly down because it sometimes gets wonky as in the shape is above the top so you can't move yet
        if(afterMT.user.x == beforeMT.user.x && beforeMT.user.x >0 && beforeMT.user.x + getWidth(beforeMT.user)<10 && (beforeMT.user.y < 4 && beforeMT.user.y > 16)) {
            System.out.println("Didn't move R");
        }
        if(afterMT.user.y < beforeMT.user.y) {
            System.out.println("YOU MOVED UP?!");
        }
        
    }
    
    public static void movedLeft() {
        Shapes user = randomShapes();
        TetrisWorld before = testWorld(user,randomPlaced(randomInt()));
        TetrisWorld after = testWorld(user,randomPlaced(randomInt())).onKeyEvent("left");
        if(after.user.x < 0) {
            System.out.println("moved through left wall full");
        }
        if(after.user.y < before.user.y) {
            System.out.println("YOU MOVED UP?!");
        }
        for(int i = 0; i < after.placedShapes.size(); i ++) {
            if(after.user.x == before.user.x && before.user.x !=0 
                && (before.user.x <9 && before.user.y > 15) 
                    && after.user.x == placedShapes.get(i).x 
                    && after.user.y == placedShapes.get(i).y) {
               System.out.println("Moved into block");
            }
        }
    }
    public static void movedRight() {
        Shapes user = randomShapes();
        TetrisWorld before = testWorld(user,randomPlaced(randomInt()));
        TetrisWorld after = testWorld(user,randomPlaced(randomInt())).onKeyEvent("right");
        if(after.user.x < 0) {
            System.out.println("moved through left wall full");
        }
        if(after.user.y < before.user.y) {
            System.out.println("YOU MOVED UP?!");
        }
        for(int i = 0; i < after.placedShapes.size(); i ++) {
            if(after.user.x == before.user.x && 
                    (before.user.x  + getHeight(user) < 10 && before.user.y > 15) 
                    && after.user.x == placedShapes.get(i).x 
                    && after.user.y == placedShapes.get(i).y) {
               System.out.println("Moved into block");
            }
        }
    }
    
    public static void onGround() {
        TetrisWorld test = testWorld(randomShapes(),MT);
        if(randomInt() > 3) {
            test.user.setPos(5, 19);
                if(test.onFloorHuh() == false) {
                    System.out.println("Onfloor not true");
                }
        }
        else {
            if(test.onFloorHuh() == true && test.user.y + getHeight(user) <20) {
                System.out.println("Not on floor");
            }
        }
    }
    
    public static void heightWidthTest() {
        Shapes test = randomShapes();
        int height = getHeight(test);
        int width = getWidth(test);
        switch(test.getType()) {
            case 0: // square
                if(height != 2 || width != 2)
                    System.out.println("square fail");
                break;
            case 1: //s
                if(((height!= 2) && (width !=3) || ((height != 3) && (width !=2))))
                    System.out.println("S fail");
                break;
            case 2: //line
                if(((height!= 4) && (width !=1) || ((height != 1) && (width !=4))))
                    System.out.println("Line fail");
                break;
            case 3:
                if(((height!= 2) && (width !=3) || ((height != 3) && (width !=2))))
                    System.out.println("T fail");
                break;
            case 4:
                if(((height!= 2) && (width !=3) || ((height != 3) && (width !=2))))
                    System.out.println("z fail");
                break;
            case 5:
                if(((height!= 3) && (width !=2) || ((height != 2) && (width !=3))))
                    System.out.println("L fail");
                break;
            case 6:
                if(((height!= 3) && (width !=2) || ((height != 2) && (width !=3))))
                    System.out.println("rL fail");
                break;
            default: 
                throw new RuntimeException("Something got really messed up in heightWidth");
        }
    }
    
    
    public static void rotateTest() {
        Shapes shape = randomShapes();
        TetrisWorld test =  testWorld(shape, MT);
        if(randomInt() < 3) {
            test = testWorld(shape.setPos(0, 10), MT);
            if(canRotate(test.user) == false)
                System.out.println("Wrong with rotate on left wall");
        }
        else if(randomInt() == 3 || randomInt() == 4) {
            test = testWorld(makeBlock(randomInt()).setPos(9, 10), MT); 
            int type = test.user.getType();
            
            if(canRotate(test.user) == true && (type!=0 ||type!=3 || type!=4||type!=1)) {
                System.out.println("Something wrong with right wall rotate");
            }
        }
        else if(randomInt() == 5) {
            test = testWorld(makeBlock(randomInt()).setPos(4,5),MT);
            int type = test.user.getType();
            if(canRotate(test.user) == true  && (type == 0 || type == 3 || type == 4 || type ==1))
                System.out.println("Should not rotate next to block");
        }
        else if(randomInt() >= 6)
            MT.add(new Shapes(ShapeType.SQUARE, Rotation.UP, 6, 5));
            test = testWorld(shape.setPos(3, 5), MT);
            if(canRotate(test.user) == true && 
                    //Lines can touch it, so they shouldn't be able to rotate when up or down
                    (test.user.getType() != 2 && (test.user.getOrientation() != 1 &&
                    test.user.getOrientation() != 3))) {
                System.out.println("wrong with rotate on right side");
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
    
    public static void loseTest() {
        TetrisWorld test = new TetrisWorld(randomShapes().setPos(5, 10), MT);
        if(randomInt() > 3) {
            MT.add(randomShapes().setPos(5, 0));
            test = testWorld(randomShapes().setPos(5,10),MT);
            if(gameOverHuh(test) == false) {
                System.out.println("Game should be Over");
            }
        }
    }
    
    public static void getMatrixTest() {
       Shapes test = randomShapes();
       if(getMatrix(test) != SHAPES[test.getType()][test.getOrientation()]) {
           System.out.println("Something went wrong with Matrix");
       }
    }
    
    
    
    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
            testStart();
            movedLeftMT();
            movedLeft();
            movedRightMT();
            movedRight();
            onGround();
            heightWidthTest();
            rotateTest();
            loseTest();
            getMatrixTest();
            
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
        System.out.println("Get Type random is " + makeBlock(randomInt()).getType());

        System.out.println("Block on block has block below true = " + new TetrisWorld(new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 16), stackTest).blockBelow(user, stackTest));
        System.out.println("Block on block has block below true = " + new TetrisWorld(new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 18), stackTest).blockBelow(user, stackTest));

        System.out.println("Block on floor has floor below true = "
                + new TetrisWorld(new Shapes(ShapeType.SQUARE, Rotation.UP, 5, 18), MT).onFloorHuh());

         
         System.out.println("Block next to Lwall has block on right false =" + 
         new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,0,5),new LinkedList<Shapes>()).blockOnRight(user, placedShapes));
         System.out.println("Block next to Rwall has block on right true =" + 
         new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,8,5),new LinkedList<Shapes>()).blockOnRight(user, placedShapes));
         System.out.println("Block next to Rwall has block on left  false = " + 
         new TetrisWorld(new Shapes(ShapeType.SQUARE,Rotation.UP,8,5),new LinkedList<Shapes>()).blockOnLeft(user,placedShapes));
        //TetrisWorld game = new TetrisWorld();
        //game.bigBang(300, 600, 1);
    }
}


