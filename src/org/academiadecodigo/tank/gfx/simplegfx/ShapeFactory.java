package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridDirection;


/**
 * Created by codecadet on 27/05/16.
 */
public class ShapeFactory {

    /**
     * Creates a new Shape for each direction and for each object type
     *
     * @param shape that receives a position X and Y
     * @param objectType
     * @param direction
     * @return a new shape - Picture
     */
    public Shape createShape(Shape shape, GameObjectType objectType, GridDirection direction) {

        if (objectType == GameObjectType.PLAYER) {

            switch (direction) {

                case UP:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Player_Tank_U.png");

                case DOWN:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Player_Tank_D.png");

                case RIGHT:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Player_Tank_R.png");

                case LEFT:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Player_Tank_L.png");

            }

        } else if (objectType == GameObjectType.ENEMY) {

            switch (direction) {

                case UP:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Enemy_Tank3_U.png");

                case DOWN:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Enemy_Tank3_D.png");

                case LEFT:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Enemy_Tank3_L.png");

                case RIGHT:
                    return new Picture(shape.getX(), shape.getY(), "resources/images/Enemy_Tank3_R.png");
            }

        }

        return new Picture(shape.getX(), shape.getY(), "resources/images/sprite_bullet.png");

    }

    /**
     * Create the initial shape at a given position
     *
     * @param x axis shape position in the grid
     * @param y axis shape position in the grid
     * @param objectType
     * @param grid //TODO-Comment- How do you explain the grid here
     * @return a new shape - Picture
     */
    public Shape createShape(int x, int y, GameObjectType objectType, SimpleGfxGrid grid) {


        switch (objectType) {

            case ENEMY:
                return new Picture(x, y, "resources/images/Enemy_Tank3_D.png");
            case PLAYER:
                return new Picture(x, y, "resources/images/Player_Tank_U.png");

            case SHELL:
                return new Picture(x, y, "resources/images/sprite_bullet.png");

            case BRICK:
                return new Picture(x,y, "resources/images/walls.png");

            case GOAL:
                return new Picture(x, y, "resources/images/goal.png");

            case BACKGROUND:
                return new Picture(x,y, "resources/images/entry.png");


        }


        return new Picture(10,10,"resources/images/Player_Tank2.png" );
    }




}
