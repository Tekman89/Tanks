package org.academiadecodigo.tank.test;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.ObjectFactory;
import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.gfx.simplegfx.Input;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
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


        SimpleGfxGrid g = new SimpleGfxGrid(80, 45);
        g.init();
        ObjectFactory factory = new ObjectFactory(g);
        GameObjects[] objects = new GameObjects[20];

//        for (int i = 0; i < 20; i++) {
//            objects[i] = factory.createObject(GameObjectType.ENEMY);
//        }

       // GridPosition pos = new SimpleGfxGridPosition(0, 0, GameObjectType.ENEMY, g);
        //test(10, pos);

//        GridPosition pos2 = new SimpleGfxGridPosition(3, 0, GameObjectType.ENEMY, g);
//        System.out.println("Horizontal: " + pos.isAdjacent((AbstractGridPosition) pos2));

//        GridPosition pos3 = new SimpleGfxGridPosition(0, 3, GameObjectType.ENEMY, g);
//        System.out.println("vertical: " + pos.isAdjacent((AbstractGridPosition) pos3));


        objects[0] = factory.createObject(GameObjectType.PLAYER);

        while(true){
            try {
                Thread.sleep(40);
//                for(GameObjects game: objects)
                ((Player) objects[0]).move();
            } catch (InterruptedException e){
                System.out.println(e);
            }
        }

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
