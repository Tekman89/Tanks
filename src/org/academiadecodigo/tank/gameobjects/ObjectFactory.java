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

/**
 * A Factory for the different Object types
 */
public class ObjectFactory implements Factory{

    private Grid grid;

    /**
     * Constructs an ObjectFactory
     *
     * @param grid in which the ObjectFactory will be placed
     */
    public ObjectFactory(Grid grid){

        this.grid = grid;

    }

    /**
     * Creates a new PLAYER
     * requires an input property
     *
     * @param myObjects type of object that can be created
     * @param inputType type of input of the object
     * @param colision  receive an collision argument//TODO-Comment- explicar melhor
     * @return a new object - PLAYER
     */
    public GameObjects createObject(GameObjectType myObjects, InputType inputType, Colision colision){

        switch (myObjects){
            case PLAYER:
                return new Player(grid.makeGridPosition(GameObjectType.PLAYER), inputType, colision);
            default:
                System.out.println("Only players are allowed to be controlled by input");
                return null;
        }

    }

    /**
     * Creates a new Goal
     *
     * @param myObject
     * @return a static game object in the grid
     */
    public GameObjects createObject(GameObjectType myObject){

        return new StaticGameObject(grid.makeGridPosition(myObject), myObject);

    }

    /**
     * Creates a new Environment
     *
     * @param col column position
     * @param row row position
     * @param brick Object type that Environment will get
     * @return A static game Object in the grid
     */
    @Override
    public GameObjects createEnvironment(int col, int row, GameObjectType brick){
        return new StaticGameObject(grid.makeGridPosition(col, row, brick), brick);
    }

    /**
     * Creates a new ENEMY
     *
     * @param myObject type of object that can be created
     * @param colision check the state of collision
     * @return a new object- ENEMY
     */
    public GameObjects createObject(GameObjectType myObject, Colision colision) {

        switch (myObject) {

            case ENEMY:
                return new Enemy(grid.makeGridPosition(GameObjectType.ENEMY), colision); // TODO: 27/05/16 add enemy constructor

            default:
                System.out.println("Something went wrong in the factory!");
                return null;
        }
    }

    /**
     * Creates a new Shell
     * requires a tank to be created
     *
     * @param tank receives an tank type
     * @param colision  receive an collision argument Todo explain argument colision
     * @return a new object - Shell
     */
    public GameObjects createShell(Tank tank, Colision colision) {
        return new Shell(grid.makeGridPosition(GameObjectType.SHELL, tank), tank, colision);
    }

}
