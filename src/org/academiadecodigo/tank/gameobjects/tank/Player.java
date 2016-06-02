package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gfx.simplegfx.InputGfx;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.utilities.Input;

/**
 * Created by codecadet on 23/05/16.
 */
public class Player extends Tank {

    private Input input = new InputGfx();


    public Player(GridPosition position) {
        super(position);

    }


    @Override
    public boolean move() {

        if (input.getDirection() != super.getDirection()) {

            getPos().replace(input.getDirection(), GameObjectType.PLAYER);
            setDirection(input.getDirection());
        }
        //System.out.println("player " + super.getPos());

        if(super.getDirection() != GridDirection.STILL || super.getDirection() != null){
            super.setPreviousDirection(super.getDirection());
        }

        return super.getPos().move(input.getDirection(), SPEED);

    }


    public boolean fire() {
        if (input.getFire()) {
            //System.out.println("Entering here");

            return true;
        }

        return false;
    }

    protected GridDirection getInput() {
        return input.getDirection();
    }


    @Override
    public void setDestroyed() {

    }
}