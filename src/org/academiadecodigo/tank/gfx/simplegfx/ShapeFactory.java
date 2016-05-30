package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.Grid;

/**
 * Created by codecadet on 27/05/16.
 */
public class ShapeFactory {

    public Shape createShape(int x, int y, GameObjectType objectType, SimpleGfxGrid grid){



        switch (objectType) {

            case ENEMY:
                int width = 10;
                int height = 10;
                //return new Rectangle(x, y, 3 * grid.getCellSize(), 3 * grid.getCellSize() );
                return new Picture(10,10, "http://0.s3.envato.com/files/85653535/Thumbnail.jpg");





                //return new Rectangle(0, 0, width, height);

            case PLAYER:
                int n = 10;
                //return new Rectangle(x, y, 3 * grid.getCellSize(), 3 * grid.getCellSize() );


            case SHELL:
                return null;

            default:
                return null;
        }

    }


}
