package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class Player extends Tank{



    public Player(GridPosition position){
        pos = position;

    }


    @Override
    public void move(GridDirection direction) {

    }


    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public void setPos(int col, int row) {

    }

    @Override
    public GridColor getColor() {
        return null;
    }

    @Override
    public void setColor(GridColor color) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public boolean equals(AbstractGridPosition position) {
        return false;
    }

    @Override
    public void moveInDirection(GridDirection direction, int distance) {

    }
}
