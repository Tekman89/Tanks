package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class Player extends Tank {

    private GridPosition pos;

    public Player(GridPosition position) {
        pos = position;

    }


    @Override
    public void moveInDirection(GridDirection direction, int speed) {

    }

    @Override
    public void setDestroyed() {

    }
}