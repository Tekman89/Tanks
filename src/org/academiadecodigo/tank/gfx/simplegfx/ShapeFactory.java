package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;

/**
 * Created by codecadet on 27/05/16.
 */
public class ShapeFactory {

    public Shape createShape(int x, int y, GameObjectType objectType){
        switch (objectType) {

            case ENEMY:
                int width = 10;
                int height = 10;
                return new Rectangle(x, y, width, height);

            case PLAYER:
                int n = 10;
                return new Rectangle(x, y, n, n);


            case SHELL:
                return null; // TODO make shell

            default:
                return null;
        }

    }

}
