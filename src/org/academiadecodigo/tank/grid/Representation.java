package org.academiadecodigo.tank.grid;

import org.academiadecodigo.tank.grid.Representable;

/**
 * Created by codecadet on 23/05/16.
 */
public class Representation implements Representable {

    private int col;
    private int row;

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
    public boolean equals(GridPosition position) {
        return false;
    }
}
