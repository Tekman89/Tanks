package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.utilities.RNG;

/**
 * Created by codecadet on 23/05/16.
 */
public class Enemy extends Tank {

    private GridPosition pos;


    public Enemy(GridPosition position) {
        pos = position;

    }


    public void chooseDirection (){

        switch (RNG.rng(4)){
            case 0 :
                super.getPos().moveInDirection(GridDirection.UP, DISTANCE);
                break;

            case 1 :
                super.getPos().moveInDirection(GridDirection.DOWN, DISTANCE);
                break;

            case 2 :
                super.getPos().moveInDirection(GridDirection.RIGHT, DISTANCE);
                break;

            case 3 :
                super.getPos().moveInDirection(GridDirection.LEFT, DISTANCE);
                break;

        }
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

    }

    @Override
    public void setDestroyed() {

    }
}
