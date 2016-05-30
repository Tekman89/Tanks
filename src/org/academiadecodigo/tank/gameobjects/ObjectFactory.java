package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.utilities.Factory;
import org.academiadecodigo.tank.utilities.RNG;

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

                return new Player(grid.makeGridPosition()); // TODO: 27/05/16 add permanent coordinates to be born


            case ENEMY:

                return new Enemy(grid.makeGridPosition(generateCol(), 0)); // TODO: 27/05/16 add enemy constructor



            default:
                System.out.println("Something went wrong in the factory!");
                return null;
        }


    }


    private int generateCol(){



        switch (RNG.rng(3)){

            case 0:
                return 0;
            case 1:
                return grid.getCols()/2;
            case 2:
                return grid.getCols();
            default:
                System.out.println("Something went wrong with the rng");
                return -1;


        }


    }


}
