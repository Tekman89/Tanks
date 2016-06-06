package org.academiadecodigo.tank.grid.position;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;

/**
 * Created by codecadet on 23/05/16.
 */

/**
 * A position on the grid that is capable of moving around
 */
public interface GridPosition {

    /**
     * Gets the position column in the grid
     *
     * @return the position column
     */
    int getCol();

    /**
     * Gets the position row in the grid
     *
     * @return the position row
     */
    int getRow();

    /**
     * Updates the position column and row
     *
     * @param col the new position column
     * @param row the new position row
     */
    void setPos(int col, int row);

    /**
     * Gets the position getColor
     *
     * @return the position getColor
     */
    GridColor getColor();

    /**
     * Changes the getColor of this grid position
     *
     * @param color the new position getColor
     */
    void setColor(GridColor color);

    /**
     * Displays the position in the grid
     */
    void show();

    /**
     * Hides the position in the grid
     */
    void hide();

    /**
     * Test if the position of the objects are overlapping
     */
    boolean isOverlapping(GridPosition position);

    /**
     * Tests if the grid position is able to move towards a specified direction
     *
     * @param direction the direction to move to
     * @param distance  the number of positions to move
     */
    boolean moveInDirection(GridDirection direction, int distance);

    /**
     * Tests if the grid position is able to move at a given speed
     *
     * @param direction the direction to move to
     * @param speed the number of positions to move per cicle
     */
    boolean move(GridDirection direction, int speed);

    /**
     * Replace an object type in the grid given the direction
     *
     * @param direction the direction to move to
     * @param objType  kind of object to be replaced
     */
    void replace(GridDirection direction, GameObjectType objType);

    /**
     *Test if an object is on edge
     */
    boolean onEdge();

    int getHeight();

    int getWidth();

    public int getCenterCol();

    public int getCenterRow();

    public Grid getGrid();


}
