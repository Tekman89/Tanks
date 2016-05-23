package org.academiadecodigo.tank.grid;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Representable {


    int getCol();

    int getRow();

    void setPos(int col, int row);

    GridColor getColor();

    void setColor(GridColor color);

    void show();

    void hide();

    boolean equals(GridPosition position);


}
