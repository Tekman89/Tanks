package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.utilities.Factory;

/**
 * Created by codecadet on 23/05/16.
 */
public class ObjectFactory implements Factory{


    private Grid grid;



    public ObjectFactory(Grid grid){

        this.grid = grid;

    }



    public GameObjects createObject(GameObjectType myObject) {

        switch (myObject) {

            case PLAYER:

                return new Player(grid.makeGridPosition(myObject)); // TODO: 27/05/16 add permanent coordinates to be born


            case ENEMY:

                return new Enemy(grid.makeGridPosition(myObject));



            default:
                return null;
        }


    }


}
