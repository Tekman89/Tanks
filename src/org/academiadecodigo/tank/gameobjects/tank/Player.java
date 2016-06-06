package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Collision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.utilities.Input;
import org.academiadecodigo.tank.utilities.InputFactory;
import org.academiadecodigo.tank.utilities.InputType;

/**
 * Created by codecadet on 23/05/16.
 */

/**
 * Specify Player class from Tanks
 */
public class Player extends Tank {

    private Input input;
    private int delay = 2;

    /**
     * Constructs a new Player
     *
     * @param position initial position on the grid
     * @param inputType get the Player waiting to the Keyboard input
     * @param colision Check the state of collision
     */
    public Player(GridPosition position, InputType inputType, Collision colision) {
        super(position, colision);
        input = InputFactory.newInput(inputType);
        super.myType = GameObjectType.PLAYER;

    }

    /**
     * @see Tank#move()#getDirection()
     * @return if the Player is able or not to move in accordance to keyboard input
     */
    @Override
    public boolean move() {


        if (input.getDirection() != super.getDirection()) {

            getPos().replace(input.getDirection(), GameObjectType.PLAYER);
            setDirection(input.getDirection());
        }

        if (super.getDirection() != GridDirection.STILL || super.getDirection() != null) {
            super.setPreviousDirection(super.getDirection());
        }


        return super.move();

    }

    /**
     * Fire method, with a delay which prevents continuous fire
     *
     * @return if the player can fire
     */
    @Override
    public boolean fire() {

        if(delay == 0 ) {
            delay = 2;
            return input.getFire() && super.fire();
        }

        delay--;
        return false;
    }

    protected GridDirection getInput() {
        return input.getDirection();
    }


}