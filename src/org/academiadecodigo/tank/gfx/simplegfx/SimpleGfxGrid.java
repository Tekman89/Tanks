package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 24/05/16.
 */
public class SimpleGfxGrid  implements Grid{
    @Override
    public void init() {

    }

    @Override
    public int getCols() {
        return 0;
    }

    @Override
    public int getRows() {
        return 0;
    }

    @Override
    public GridPosition makeGridPosition() {
        return null;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return null;
    }
}
