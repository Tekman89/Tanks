package org.academiadecodigo.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.StaticObjects;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 29/05/16.
 */
public final class Colision {

    private static LinkedList<GameObjects> mySpecialLinkedList;


    public static LinkedList<GameObjects> callColision(LinkedList<GameObjects> mySpecialList) {

        mySpecialLinkedList = mySpecialList;

        return mySpecialLinkedList;
    }


    public static void checkColision() {


        ListIterator<GameObjects> it = mySpecialLinkedList.listIterator();
        int counter = 1;


        while (it.hasNext()) {

            ListIterator<GameObjects> it2 = mySpecialLinkedList.listIterator(counter);
            GameObjects object = it.next();

            while (it2.hasNext()) {

                GameObjects object2 = it2.next();

                if(object.getPos().isAdjacent(object2.getPos())){
                    object.setDestroyed();
                    object2.setDestroyed();
                    System.out.println("colided");
                    System.out.println(object);
                    System.out.println(object2);
                }


            }
            counter++;


        }


    }


//    public boolean hasColided(Tank object){
//
////        for(GameObjects obj: gameObjects) {
////
////            if(obj == object) {
////                continue;
////            }
////
////            if(obj instanceof Tank) {
////                return object.getPos().isAdjacent(obj.getPos()) &&
////                        object.getDirection().oppositeDirection() == ((Tank) obj).getDirection();
////            }
////
////            if(obj instanceof StaticObjects) {
////
////                return object
////
////            }
////        }
//
//
//
//    }
}
