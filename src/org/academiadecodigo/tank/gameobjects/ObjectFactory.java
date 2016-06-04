package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.gameobjects.tank.Shell;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.utilities.Factory;
import org.academiadecodigo.tank.utilities.InputType;
import org.academiadecodigo.tank.utilities.RNG;

/**
 * Created by codecadet on 23/05/16.
 */
public class ObjectFactory implements Factory{


    private Grid grid;



    public ObjectFactory(Grid grid){

        this.grid = grid;

    }

    public GameObjects createObject(GameObjectType myObjects, InputType inputType, Colision colision){

        switch (myObjects){
            case PLAYER:
                return new Player(grid.makeGridPosition(GameObjectType.PLAYER), inputType, colision);
            default:
                System.out.println("Only players are allowed to be controlled by input");
                return null;
        }

    }

    public GameObjects createObject(GameObjectType myObject){

        return new StaticGameObject(grid.makeGridPosition(myObject), myObject);

    }


    @Override
    public GameObjects createEnvironment(int col, int row, GameObjectType brick){
        System.out.println(col + " " + row);
        return new StaticGameObject(grid.makeGridPosition(col, row, brick), brick);
    }



    public GameObjects createObject(GameObjectType myObject, Colision colision) {

        switch (myObject) {


            case ENEMY:
                return new Enemy(grid.makeGridPosition(GameObjectType.ENEMY), colision); // TODO: 27/05/16 add enemy constructor

            default:
                System.out.println("Something went wrong in the factory!");
                return null;
        }


    }

    public GameObjects createShell(Tank tank, Colision colision) {
        return new Shell(grid.makeGridPosition(GameObjectType.SHELL, tank), tank, colision);
    }

}
