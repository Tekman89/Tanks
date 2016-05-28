package org.academiadecodigo.tank.test;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.tank.grid.Grid;
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
        GridPosition pos = new SimpleGfxGridPosition(0, 0, GameObjectType.ENEMY, g);
        test(10, pos);

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
