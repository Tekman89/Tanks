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
public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;
    private Grid grid;
    private GridColor color;
    private int height;
    private int width;


    public AbstractGridPosition(int col, int row, Grid grid) {

        this.col = col;
        this.row = row;
        this.grid = grid;

    }

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

    public int getCol() {

        return col;
    }

    public int getRow() {

        return row;

    }

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

    public boolean moveUp(int distance) {

        int maxRowsUp = distance < getRow() ? distance : getRow();
        setPos(getCol(), getRow() - maxRowsUp);
        return !(maxRowsUp == 0);
    }

    public boolean moveDown(int distance) {

        int maxRowsDown = distance > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : distance;
        setPos(getCol(), getRow() + maxRowsDown);
        return !(maxRowsDown == 0);
    }

    public boolean moveLeft(int distance) {

        int maxColsLeft = distance < getCol() ? distance : getCol();
        setPos(getCol() - maxColsLeft, getRow());
        return !(maxColsLeft == 0);
    }

    public boolean moveRight(int distance) {

        int maxColsRight = distance > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol() + 1) : distance;
        setPos(getCol() + maxColsRight, getRow());

        return !(maxColsRight == 0);

    }


    @Override
    public boolean isAdjacentRow(GridPosition position) {

        return Math.abs(getCenterRow() - position.getCenterRow()) <= ((height / 2) + position.getHeight()/2) &&
                (col + position.getCol() > col + width ||
                col + width < position.getCol()); //&&
                //Math.abs(getCenterCol() - position.getCenterCol()) <= ((width / 2) + position.getWidth()/2);

    }

    @Override
    public boolean isAdjacentCol(GridPosition position) {

        return Math.abs(getCenterCol() - position.getCenterCol()) == (width / 2 + position.getWidth()) &&
                (row + position.getRow() > row + height ||
                row + height < position.getRow());

    }

    @Override
    public boolean isOverlapping(GridPosition position) {

        return Math.abs(getCenterCol() - position.getCenterCol()) < (width / 2 +  position.getWidth() / 2) &&
                Math.abs(getCenterRow() - position.getCenterRow()) < (height / 2.0 + position.getHeight() / 2.0);


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

    public int getCenterCol(){

        return col + height / 2;

    }

    public int getCenterRow(){

        return row + width / 2;
    }


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

