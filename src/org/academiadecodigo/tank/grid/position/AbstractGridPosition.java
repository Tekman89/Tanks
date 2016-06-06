package org.academiadecodigo.tank.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;

/**
 * Created by codecadet on 23/05/16.
 */

/**
 * Base skelleton for a grid position
 *
 * @see GridPosition
 */
public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;
    private Grid grid;
    private GridColor color;
    private int height;
    private int width;

    /**
     * Construct a new grid position at a specific column and row
     *
     * @param col   the column of the grid position
     * @param row   the row of the grid position
     * @param grid  the grid in which the position will be displayed
     */
    public AbstractGridPosition(int col, int row, Grid grid) {

        this.col = col;
        this.row = row;
        this.grid = grid;

    }

    /**
     * @see GridPosition#setPos(int, int)
     */
    public void setPos(int col, int row) {

        this.col = col;
        this.row = row;
        show();
    }

    public void setColor(GridColor color) {

        this.color = color;
        show();
    }

    public Grid getGrid() {

        return grid;
    }

    /**
     * @see GridPosition#getCol()
     */
    public int getCol() {

        return col;
    }

    /**
     * @see GridPosition#getRow()
     */
    public int getRow() {

        return row;

    }

    /**
     * @see GridPosition#getColor()
     */
    public GridColor getColor() {

        return color;
    }

    public boolean move(GridDirection direction, int speed) {


        while (speed > 0) {
            if (!moveInDirection(direction, 1)) {
                return false;
            }

            speed--;
        }

        return true;

    }
    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    public boolean moveInDirection(GridDirection direction, int distance) {
        switch (direction) {

            case UP:
                return moveUp(distance);

            case DOWN:
                return moveDown(distance);

            case LEFT:
                return moveLeft(distance);

            case RIGHT:
                return moveRight(distance);
        }

        return false;
    }

    /**
     * Condition that allow the object to move the position up
     *
     * @param distance the number of positions to move
     * @return false if the objects can't move further up
     */
    public boolean moveUp(int distance) {

        int maxRowsUp = distance < getRow() ? distance : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
        return !(maxRowsUp == 0);
    }

    /**
     * Condition that allow the object to move the position down
     *
     * @param distance the number of positions to move
     * @return false if the objects can't move further down
     */
    public boolean moveDown(int distance) {

        int maxRowsDown = distance > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : distance;
        setPos(getCol(), getRow() + maxRowsDown);
        return !(maxRowsDown == 0);
    }

    /**
     * Condition that allow the object to move the position to the left
     *
     * @param distance the number of positions to move
     * @return false if the objects can't move further left
     */
    public boolean moveLeft(int distance) {

        int maxColsLeft = distance < getCol() ? distance : getCol();
        setPos(getCol() - maxColsLeft, getRow());
        return !(maxColsLeft == 0);
    }

    /**
     * Condition that allow the object to move the position right
     *
     * @param distance the number of positions to move
     * @return false if the objects can't move further right
     */
    public boolean moveRight(int distance) {

        int maxColsRight = distance > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : distance;
        setPos(getCol() + maxColsRight, getRow());

        return !(maxColsRight == 0);

    }

    /**
     * Condition that evaluates if two objects are overlapping
     *
     * @param position is an object of the type GridPosition that carries the coordinates of another object on the Grid
     * @return true in the objects are overlapping
     */
    @Override
    public boolean isOverlapping(GridPosition position) {


        return Math.sqrt(Math.abs(getCenterCol() - position.getCenterCol()) * Math.abs(getCenterCol() - position.getCenterCol())
                + Math.abs(getCenterRow() - position.getCenterRow()) * Math.abs(getCenterRow() - position.getCenterRow())) <=
                height / 2 + position.getHeight() / 2;


    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCenterCol() {

        return col + width / 2; // get center position of one side of the object

    }

    public int getCenterRow() {

        return row + height / 2;// get center position of the other side of the object

    }

    /**
     * @see GridPosition#onEdge()
     * @return if its on edge in the for sides of the grid
     */

    @Override
    public boolean onEdge() {
        return (col <= getGrid().getMARGIN() ||
                col + width >= getGrid().getCols() + width - getGrid().getMARGIN() ||
                row <= getGrid().getMARGIN() ||
                row + height >= getGrid().getRows() + height - getGrid().getMARGIN());
    }


    @Override
    public String toString() {
        return "GridPosition{" +
                "col=" + col +
                ", row=" + row +
                ", getColor=" + color +
                '}';
    }

}

