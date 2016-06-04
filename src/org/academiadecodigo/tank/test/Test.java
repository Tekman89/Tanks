package org.academiadecodigo.tank.test;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.ObjectFactory;
import org.academiadecodigo.tank.gameobjects.tank.*;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.utilities.InputType;

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

      int timer = 10;

        SimpleGfxGrid g = new SimpleGfxGrid(120, 80);
        g.init();
        ObjectFactory factory = new ObjectFactory(g);
        Colision colision;

        LinkedList<GameObjects> linkedList = new LinkedList();
        colision = new Colision(linkedList);
        linkedList.add(factory.createObject(GameObjectType.PLAYER, InputType.SIMPLEGFX, colision));






        for (int i = 0; i < 3; i++) {
         linkedList.add(factory.createObject(GameObjectType.ENEMY,colision));

        }


        //  GridPosition pos = new SimpleGfxGridPosition(0, 0, GameObjectType.ENEMY, g);
        // test(10, pos);

//        GridPosition pos2 = new SimpleGfxGridPosition(3, 0, GameObjectType.ENEMY, g);
//        System.out.println("Horizontal: " + pos.isAdjacent((AbstractGridPosition) pos2));

//        GridPosition pos3 = new SimpleGfxGridPosition(0, 3, GameObjectType.ENEMY, g);
//        System.out.println("vertical: " + pos.isAdjacent((AbstractGridPosition) pos3));


        while (true) {
            ListIterator<GameObjects> it = linkedList.listIterator(0);
            try {
                Thread.sleep(50);
                for (int i = 0; i < linkedList.size(); i++) {

                    if(!it.hasNext()) {
                        break;
                    }
                        GameObjects object = it.next();



                    if (object instanceof MovableDestroyable) {


                        /**
                         *
                         *  Shell will disappear when it reaches the edge
                         *
                         */


                        if(!((MovableDestroyable)object).move() && object instanceof Shell){
                          object.setDestroyed();
                        }

                        if (object instanceof Tank) {
                            Tank tank = (Tank) object;

                            if (tank.fire()){
                                it.add(factory.createShell(tank));
                            }
                        }


                        colision.checkHitTarget();


                    }

                    if(object.isDestroyed()){
                        object.getPos().hide();

                       try{
                           it.remove();
                       }catch (Exception e){
                           System.out.println("Fuck u");;
                       }
                    }

                }

            } catch (InterruptedException e) {
                e.getMessage();
            }

            timer--;
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

                pos.setColor(cycles % 2 == 0 ? GridColor.BLUE : GridColor.RED);

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
