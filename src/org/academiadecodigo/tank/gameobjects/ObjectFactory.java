package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class ObjectFactory {


    public GridPosition createObject(GameObjectType myObject) {

        switch (myObject) {

            case TANK:

            default:
                return new Rectangle();
        }


    }


}
