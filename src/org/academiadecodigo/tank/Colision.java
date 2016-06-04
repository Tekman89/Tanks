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
     * check Colision only for shells
     * updates the linked list
     */

    public Colision(LinkedList<GameObjects> linkedList) {

        this.mySpecialLinkedList = linkedList;

    }

    public void checkHitTarget() {

        ListIterator<GameObjects> it = mySpecialLinkedList.listIterator();

        while (it.hasNext()) {

            ListIterator<GameObjects> it2 = mySpecialLinkedList.listIterator();
            GameObjects object = it.next();

            while (it2.hasNext()) {

                GameObjects object2 = it2.next();

                if(object.equals(object2)){
                    continue;
                }

                if(object.getPos().isOverlapping(object2.getPos())){
                    System.out.println(Math.sqrt(Math.abs(object.getPos().getCenterCol() - object2.getPos().getCenterCol()) * Math.abs(object.getPos().getCenterCol() - object2.getPos().getCenterCol())
                            + Math.abs(object.getPos().getCenterRow() - object2.getPos().getCenterRow()) * Math.abs(object.getPos().getCenterRow() - object2.getPos().getCenterRow())));

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


                    if (hitObject(((Shell) object), object2)) {
                        System.out.println("entered the first");
                        object.setDestroyed();
                        object2.setDestroyed();
                    }

                }

                if (object2 instanceof Shell) {


                    if (hitObject((Shell) object2, object)) {

                        System.out.println("entered");
                        object.setDestroyed();
                        object2.setDestroyed();
                    }

                }


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


            if(!(Math.sqrt((Math.abs(tankX - objX)) * Math.abs(tankX - objX) + Math.abs(tankY - objY) * Math.abs(tankY - objY)) >= tank.getPos().getHeight()) && !(object instanceof Shell)){
                safeAll = false;
            }
        }
        tank.setSafeMove(safeAll);
    }
}
