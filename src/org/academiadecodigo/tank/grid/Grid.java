package org.academiadecodigo.tank.grid;

import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Grid {


    public void init();

    public int getCols();

    public  int getRows();

    public GridPosition makeGridPosition();

    public GridPosition makeGridPosition(int col, int row);


}
