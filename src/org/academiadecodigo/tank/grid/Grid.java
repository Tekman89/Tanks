package org.academiadecodigo.tank.grid;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Grid {

    /**
     * Initializes the grid
     */
    public void init();

    /**
     * Gets the number of columns in the grid
     *
     * @return the number of columns
     */
    public int getCols();

    /**
     * Gets the number of rows in the grid
     *
     * @return the number of rows
     */
    public int getRows();

    /**
     * Gets the get the margin in the grid
     *
     * @return the number of rows
     */
    public int getMARGIN();

     //public GridPosition makeGridPosition();

    /**
     * Creates a a grid position in a specific column and row with a given object type
     *
     * @param col   the position column
     * @param row   the position row
     * @param objectType
     * @return the new grid position
     */
    public GridPosition makeGridPosition(int col, int row, GameObjectType objectType);

    public GridPosition makeGridPosition(GameObjectType objectType);

    public GridPosition makeGridPosition(GameObjectType objectType, Tank myTank);

}
