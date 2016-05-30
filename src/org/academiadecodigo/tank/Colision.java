package org.academiadecodigo.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.StaticObjects;
import org.academiadecodigo.tank.gameobjects.tank.Movable;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 29/05/16.
 */
public class Colision {

    private GameObjects gameObjects[];

    public Colision(GameObjects[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    public boolean hasColided(Tank object){

        for(GameObjects obj: gameObjects) {

            if(obj == object) {
                continue;
            }

            if(obj instanceof Tank) {
                return object.getPos().isAdjacent(obj.getPos()) &&
                        object.getDirection().oppositeDirection() == obj.getDirection();
            }

            if(obj instanceof StaticObjects) {

                return object.

            }
        }



    }
}
