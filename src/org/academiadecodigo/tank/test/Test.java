package org.academiadecodigo.tank.test;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.ObjectFactory;
import org.academiadecodigo.tank.gameobjects.tank.*;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.utilities.InputType;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 23/05/16.
 */
public class Test {

    /*

    Check limits,

    collisions,

    destroyable,

    hit each other,

    fire,

    delete,

    show,

    move,

     */

    public static int TEST_DELAY = 500;
    public static int TEST_STEP = 800;
    public static void main(String[] args) {


        SimpleGfxGrid g = new SimpleGfxGrid(120, 80);
        g.init();
        ObjectFactory factory = new ObjectFactory(g);
        GameObjects[] objects = new GameObjects[20];


        for (int i = 0; i < objects.length; i++) {

            if (i == 0){
                objects[i] = factory.createObject(GameObjectType.PLAYER, InputType.SIMPLEGFX);
            } else if( i < 19){
              objects[i] = factory.createObject(GameObjectType.ENEMY);
            }

        }

      //  GridPosition pos = new SimpleGfxGridPosition(0, 0, GameObjectType.ENEMY, g);
        // test(10, pos);

//        GridPosition pos2 = new SimpleGfxGridPosition(3, 0, GameObjectType.ENEMY, g);
//        System.out.println("Horizontal: " + pos.isAdjacent((AbstractGridPosition) pos2));

//        GridPosition pos3 = new SimpleGfxGridPosition(0, 3, GameObjectType.ENEMY, g);
//        System.out.println("vertical: " + pos.isAdjacent((AbstractGridPosition) pos3));



        while(true){
            try{
                Thread.sleep(30);

                for( int i = 0; i < objects.length; i++) {

                    if(objects[i] instanceof MovableDestroyable){


                        if(objects[i] instanceof Shell && !((MovableDestroyable)objects[i]).move()){
                            objects[i].getPos().hide();
                            objects[i] = null;

                        }

                        if(objects[i] != null) {
                            ((MovableDestroyable) objects[i]).move();
                        }


                        if(objects[i] instanceof Player){
                            Player player = (Player) objects[i];

                            if(player.fire() && objects[19] == null){
                                 objects[19] = factory.createShell(((Tank) objects[0]));



                                ((Shell) objects[19]).move();

                            }

                        }

                    }
                }

            } catch (InterruptedException e){
                e.getMessage();
            }


        }


//        while(true){
//            try {
//                Thread.sleep(30);
//                ((Player) objects).move();
//            } catch (InterruptedException e){
//                System.out.println(e);
//            }
//        }
//
    }


    public static void test(int cycles, GridPosition pos) {

        try {

            while (cycles > 0) {

                pos.setColor(cycles % 2 == 0? GridColor.BLUE : GridColor.RED);

                System.out.println(pos);
                cycles--;

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.DOWN, TEST_STEP);
                System.out.println(pos);

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.RIGHT, TEST_STEP);
                System.out.println(pos);

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.UP, TEST_STEP);
                System.out.println(pos);

                Thread.sleep(TEST_DELAY);
                pos.moveInDirection(GridDirection.LEFT, TEST_STEP);
                System.out.println(pos);

                Thread.sleep(TEST_DELAY);
                pos.hide();

                Thread.sleep(TEST_DELAY);
                pos.show();

            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }


}
