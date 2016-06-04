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
public class Player extends Tank {

    private Input input;
    private int delay = 2;


    public Player(GridPosition position, InputType inputType, Colision colision) {
        super(position, colision);
        input = InputFactory.newInput(inputType);

        super.myType = GameObjectType.PLAYER;

    }


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