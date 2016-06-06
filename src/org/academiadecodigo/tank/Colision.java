package org.academiadecodigo.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.gameobjects.tank.Shell;
import org.academiadecodigo.tank.gameobjects.tank.Tank;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 29/05/16.
 */
public class Colision {

    private LinkedList<GameObjects> mySpecialLinkedList;

    /**
     * Verify is Shell has collided with other object
     *
     * @param linkedList list of all the game objects
     */
    public Colision(LinkedList<GameObjects> linkedList) {

        this.mySpecialLinkedList = linkedList;

    }

    /**
     * Checks if a shell has hit an object from the linked list
     *
     */
    public void checkHitTarget() {

        ListIterator<GameObjects> it = mySpecialLinkedList.listIterator();

        while (it.hasNext()) {

            ListIterator<GameObjects> it2 = mySpecialLinkedList.listIterator();
            GameObjects object = it.next();

            while (it2.hasNext()) {

                GameObjects object2 = it2.next();

                if (object.equals(object2)) {
                    continue;
                }

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


                    if (hitObject(((Shell) object), object2) && !((Shell) object).sameType(object2)) {

                        object.setDestroyed();
                        object2.setDestroyed();
                    }

                }

                if (object2 instanceof Shell) {


                    if (hitObject((Shell) object2, object) && !((Shell) object2).sameType(object)) {

                        object.setDestroyed();
                        object2.setDestroyed();
                    }

                }


            }

        }

    }

    /**
     * Verifies if a object overlaps object2
     *
     * @param object of Shell type
     * @param object2
     * @return true is have overlapped
     */
    private boolean hitObject(Shell object, GameObjects object2) {

        return object.getPos().isOverlapping(object2.getPos()) && !object.whoFired().equals(object2);

    }

    private boolean hitObject(Shell object, Shell object2) {

        return object.getPos().isOverlapping(object2.getPos());

    }


    /**
     * Check if it is safe to move to the next position
     *
     * @param tank object from tank class
     */

    public void isSafe(Tank tank) {

        Iterator<GameObjects> it = mySpecialLinkedList.listIterator();
        boolean safeAll = true;
        while (it.hasNext()) {

            GameObjects object = it.next();

            if (object.equals(tank)) {
                continue;
            }
            int tankX = tank.getPos().getCenterCol();
            int objX = object.getPos().getCenterCol();

            int tankY = tank.getPos().getCenterRow();
            int objY = object.getPos().getCenterRow();


            if (!(Math.sqrt((Math.abs(tankX - objX)) * Math.abs(tankX - objX) + Math.abs(tankY - objY) * Math.abs(tankY - objY)) >= tank.getPos().getHeight()) && !(object instanceof Shell)) {
                safeAll = false;
            }
        }
        tank.setSafeMove(safeAll);
    }
}
