package org.academiadecodigo.tank.gameobjects.tank;

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
    public void move() {
        super.getPos().moveInDirection(input.getDirection(), SPEED);

    }

    public void move(GridDirection direction){
        System.out.println(direction);
        System.out.println(super.getPos());
        super.getPos().moveInDirection(direction, SPEED);
    }

    @Override
    public void setDestroyed() {

    }
}