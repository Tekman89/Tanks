package org.academiadecodigo.tank;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.StaticGameObject;
import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.gameobjects.tank.Shell;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 29/05/16.
 */
public class Collision {

    private LinkedList<GameObjects> mySpecialLinkedList;

    /**
     * check Collision only for shells
     * updates the linked list
     */

    public Collision(LinkedList<GameObjects> linkedList) {

        this.mySpecialLinkedList = linkedList;

    }

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

    private boolean hitObject(Shell object, GameObjects object2) {

        return object.getPos().isOverlapping(object2.getPos()) && !object.whoFired().equals(object2);
    }

    private boolean hitObject(Shell object, Shell object2) {

        return object.getPos().isOverlapping(object2.getPos());
    }

    /**
     * check if it's safe to move to the next position
     *
     * @return
     */


    public void isSafe(Tank tank) {

        Iterator<GameObjects> it = mySpecialLinkedList.listIterator();
        boolean safeCol = true;
        boolean safeRow = true;
        while (it.hasNext()) {

            GameObjects object = it.next();

            if (object.equals(tank) || object instanceof StaticGameObject && ((StaticGameObject) object).getGameObjectType() == GameObjectType.GOAL) {
                continue;
            }

            // if tank is in adjacent cell to another object, checks if has forbidden direction and if true set safe property to false

            if(((AbstractGridPosition)tank.getPos()).adjacentCol(object.getPos())) {

                safeCol = !(tank.getPos().getCol() >= object.getPos().getCol() &&
                            tank.getDirection() == GridDirection.LEFT ||
                            tank.getPos().getCol() <= object.getPos().getCol() &&
                            tank.getDirection() == GridDirection.RIGHT);
            }

            if(((AbstractGridPosition) tank.getPos()).adjacentRow(object.getPos()))  {

                safeRow = !(tank.getPos().getRow() <= object.getPos().getRow() &&
                            tank.getDirection() == GridDirection.DOWN ||
                            tank.getPos().getRow() >= object.getPos().getRow() &&
                                    tank.getDirection() == GridDirection.UP);

            }
        }
        if(!safeRow || !safeCol) {
            tank.setSafeMove(false);
        } else {
            tank.setSafeMove(true);
        }
    }


    public boolean reachGoal(){

        ListIterator<GameObjects> it = mySpecialLinkedList.listIterator();

        GameObjects player = null;
        GameObjects goal = null;

        while(it.hasNext()){

            GameObjects object = it.next();

            if(object instanceof Player){
                player = object;
            } else if(object instanceof StaticGameObject && ((StaticGameObject) object).getGameObjectType() == GameObjectType.GOAL) {
                goal = object;
            }

        }

        if(player != null && goal != null) {

           return player.getPos().isOverlapping(goal.getPos());

        }

        return false;
    }
}
