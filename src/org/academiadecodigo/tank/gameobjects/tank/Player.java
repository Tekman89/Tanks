package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gfx.simplegfx.InputGfx;
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

    private Input input;//input from keyboard

    /**
     * Constructs a new Player
     *
     * @param position initial position on the grid
     * @param inputType get the Player waiting to the Keyboard input
     * @param colision Check the state of collision
     */
    public Player(GridPosition position, InputType inputType, Colision colision) {
        super(position,colision);
        input = InputFactory.newInput(inputType);
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

        if(super.getDirection() != GridDirection.STILL || super.getDirection() != null){
            super.setPreviousDirection(super.getDirection());
        }

        return super.move();

    }

    /**
     * @return true if the input key is pressed
     */
    public boolean fire() {
        if (input.getFire()) {

            return true;
        }

        return false;
    }

    protected GridDirection getInput() {// TODO see what this Method does
        return input.getDirection();
    }
}