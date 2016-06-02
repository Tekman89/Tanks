package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridDirection;

import java.util.Spliterator;

/**
 * Created by codecadet on 27/05/16.
 */
public class ShapeFactory {

    // TODO: 31/05/16 in accordance with the direction add a different picture.


    public Shape createShape(Shape shape, GameObjectType objectType, GridDirection direction) {

        if (objectType == GameObjectType.PLAYER) {

            switch (direction) {

                case UP:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Player_Tank_U.png");

                case DOWN:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Player_Tank_D.png");

                case RIGHT:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Player_Tank_R.png");

                case LEFT:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Player_Tank_L.png");

            }

        } else if (objectType == GameObjectType.ENEMY) {

            switch (direction) {

                case UP:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Enemy_Tank3_U.png");

                case DOWN:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Enemy_Tank3_D.png");

                case LEFT:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Enemy_Tank3_L.png");

                case RIGHT:
                    return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Enemy_Tank3_R.png");
            }

        }

        return new Picture(shape.getX(), shape.getY(), "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/sprite_bullet.png");

    }

    public Shape createShape(int x, int y, GameObjectType objectType, SimpleGfxGrid grid) {


        switch (objectType) {

            case ENEMY:
                int width = 10;
                int height = 10;
                //return new Rectangle(x, y, 3 * grid.getCellSize(), 3 * grid.getCellSize() );
                return new Picture(x, y, "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Enemy_Tank3_D.png");


            //return new Rectangle(0, 0, width, height);

            case PLAYER:
                int n = 10;
                //return new Rectangle(x, y, 6 * grid.getCellSize(), 6 * grid.getCellSize() );
                return new Picture(x, y, "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Player_Tank_U.png");

            case SHELL:
                return new Picture(x, y, "/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/sprite_bullet.png");


        }


        return new Picture(10,10,"/Users/codecadet/IdeaProjects/groupProject/Tanks/images/images/Player_Tank2.png" );
    }




}
