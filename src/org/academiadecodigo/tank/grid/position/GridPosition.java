package org.academiadecodigo.tank.grid.position;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;

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

    boolean isAdjacent(AbstractGridPosition position);

    boolean moveInDirection(GridDirection direction, int distance);

    boolean move(GridDirection direction, int speed);

    void replace(GridDirection direction, GameObjectType objType);

    boolean onEdge();


}
