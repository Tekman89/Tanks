package org.academiadecodigo.tank.grid.position;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class AbstractGridPosition implements GridPosition {

    private  int col;
    private int row;
    private Grid grid;
    private GridColor color;

    public AbstractGridPosition(int col, int row , Grid grid){

        this.col = col;
        this.row = row;
        this.grid = grid;

    }

    public void setPos(int col, int row){

        this.col = col;
        this.row = row;
        show();
    }

    public void setColor(GridColor color){

        this.color = color;
        show();
    }

    public Grid getGrid(){

        return grid;
    }

    public int getCol(){

        return col;
    }

    public int getRow(){

        return row;

    }
    public GridColor getColor(){

        return color;
    }

    public void moveInDirection(GridDirection direction, int distance){
        switch (direction){

            case UP:
                moveUp(distance);
                break;

            case DOWN:
                moveDown(distance);
                break;

            case LEFT:
                moveLeft(distance);
                break;

            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    public void moveUp(int distance){

        int maxRowsUp = distance < getRow() ? distance : getRow();
        setPos(getCol(), getRow() - maxRowsUp);

    }

    public void moveDown(int distance){

        int maxRowsUp = distance > getGrid().getRows() - (getRow() +1)  ?  getGrid().getRows() - (getRow() +1) : distance;
        setPos(getCol(), getRow() + maxRowsUp);
    }

    public void moveLeft(int distance){

        int maxColsLeft = distance < getCol() ? distance : getCol();
        setPos(getCol() - maxColsLeft, getRow());

    }

    public void moveRight(int distance){

        int maxColsRight = distance > getGrid().getCols() - (getCol()+1) ? getGrid().getCols() - (getCol()+1) : distance;
        setPos(getCol() + maxColsRight, getRow());

    }

    public boolean isAdjacent(AbstractGridPosition position){
        int objWidth = 3; // obj size to do
        int objHeight = 3; // obj size to do

        double center2 = objWidth / 2.0;
        double center1 = objWidth / 2.0;

        double centerCol1 = col + center1;
        double centerCol2 = position.getCol() + center2;

        double centerRow1 = col + objHeight / 2.0;
        double centerRow2 = position.getRow() + objHeight / 2.0;


        return Math.abs(centerCol1 - centerCol2) <= (center1 + center2) &&
                Math.abs(centerRow1 - centerRow2) <= (objHeight/2.0 + objHeight/2.0);

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

