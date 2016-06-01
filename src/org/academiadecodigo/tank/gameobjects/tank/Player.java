package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gfx.simplegfx.Input;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class Player extends Tank {

    private Input input = new Input();


    public Player(GridPosition position) {
        super(position);

    }


    @Override
    public boolean move() {

        if(input.getDirection() != super.getDirection()){
            getPos().replace(input.getDirection(), GameObjectType.PLAYER);
        }
       // System.out.println(super.getPos());
        return super.getPos().move(input.getDirection(), SPEED);

    }


    public boolean fire() {
        if (input.getFire()) {
            System.out.println("Entering here");

            return true;
        }

        return false;
    }

    protected GridDirection getInput(){
        return input.getDirection();
    }


    @Override
    public void setDestroyed() {

    }
}