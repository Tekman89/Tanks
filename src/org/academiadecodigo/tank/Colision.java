package org.academiadecodigo.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.tank.MovableDestroyable;
import org.academiadecodigo.tank.gameobjects.tank.Shell;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.GridDirection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 29/05/16.
 */
public class Colision {

    private LinkedList<GameObjects> mySpecialLinkedList;

    /**
     * check Colision only for shells
     * updates the linked list
     */

    public Colision(LinkedList<GameObjects> linkedList) {

        this.mySpecialLinkedList = linkedList;

    }

    public void checkHitTarget() {

        ListIterator<GameObjects> it = mySpecialLinkedList.listIterator();
        int counter = 1;

        while (it.hasNext()) {

            ListIterator<GameObjects> it2 = mySpecialLinkedList.listIterator(counter);
            GameObjects object = it.next();

            while (it2.hasNext()) {

                GameObjects object2 = it2.next();

                if (!(object instanceof Shell) && !(object2 instanceof Shell)) {
                    continue;
                }

                if (object instanceof Shell && object2 instanceof Shell) {

                    if (hitObject((Shell) object, (Shell) object2)) {
                        object.setDestroyed();
                        object2.setDestroyed();

                    }

                }

                if (object instanceof Shell) {

                    if (hitObject(((Shell) object), object2)) {
                        object.setDestroyed();
                        object2.setDestroyed();
                    }

                }

                if (object2 instanceof Shell) {

                    if (hitObject((Shell) object2, object)) {
                        object.setDestroyed();
                        object2.setDestroyed();
                    }

                }

                counter++;

            }

        }

    }

    private boolean hitObject(Shell object, GameObjects object2) {

        return object.getPos().isOverlapping(object2.getPos()) && !object.whoFired().equals(object2);

    }

    private boolean hitObject(Shell object, Shell object2) {

        return object.getPos().isOverlapping(object2.getPos());

    }

    /**
     * check if is safe to move to the next position
     *
     * @return
     */


    public boolean isSafe(Tank tank) {

        Iterator<GameObjects> it = mySpecialLinkedList.listIterator();
        boolean result = false;
        while (it.hasNext()) {

            GameObjects object = it.next();

            if (object.equals(tank)) {
                continue;
            }
            /*if (tank.getPos().isAdjacentRow(object.getPos())) {

                System.out.println(tank.getPos().getRow() - object.getPos().getRow() + " Rows " + tank.getPos().getCol());

                System.out.println(tank.getPos().getCenterRow() <= object.getPos().getCenterRow() && tank.getDirection() != GridDirection.DOWN);

                return object instanceof Shell ||
                        tank.getPos().getCenterRow() < object.getPos().getCenterRow() && (tank.getDirection() != GridDirection.DOWN) ||
                        tank.getPos().getCenterRow() > object.getPos().getCenterRow() && (tank.getDirection() != GridDirection.UP);

            }
            if(tank.getPos().isAdjacentCol(object.getPos())) {

                return tank.getPos().getCenterCol() < object.getPos().getCenterCol() && (tank.getDirection() != GridDirection.RIGHT) ||
                        tank.getPos().getCenterCol() > object.getPos().getCenterCol() && (tank.getDirection() != GridDirection.LEFT);
            }


        }*/
            int tankX = tank.getPos().getCenterCol();
            int objX = object.getPos().getCenterCol();

            int tankY = tank.getPos().getCenterRow();
            int objY = object.getPos().getCenterRow();

            result =  Math.sqrt((Math.abs(tankX - objX)) * Math.abs(tankX - objX) + Math.abs(tankY - objY) * Math.abs(tankY - objY)) >= tank.getPos().getHeight();

        }
        return result;
    }
}
