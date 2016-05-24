package org.academiadecodigo.tank.grid.position;

import org.academiadecodigo.tank.grid.GridColor;

/**
 * Created by codecadet on 23/05/16.
 */
public interface GridPosition {


    int getCol();

    int getRow();

    void setPos(int col, int row);

    GridColor getColor();

    void setColor(GridColor color);

    void show();

    void hide();

    boolean equals(AbstractGridPosition position);


}
