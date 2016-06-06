package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Shape shape;
    private ShapeFactory factory = new ShapeFactory();
    private GameObjectType type;

    /**
     * Creates a new position for an object type in the SimpleGfxGrid ata specified column and row
     *
     * @param col the column number
     * @param row the row number
     * @param objectType the object type tha will be displayed
     * @param grid the grid in which the position will be displayed
     */
    public SimpleGfxGridPosition(int col, int row, GameObjectType objectType, SimpleGfxGrid grid) {

        super(col, row, grid);
        shape = factory.createShape(toPixel(col) + grid.getMARGIN(), toPixel(row) + grid.getMARGIN(), objectType, grid);
        show();
        super.setHeight(toRows(shape.getHeight()));
        super.setWidth(toRows(shape.getWidth()));
        type = objectType;
    }

    /**
     * Utility that gets the n integer converted to pixels
     *
     * @param n integer to be converted
     * @return Pixel value of integer n
     */
    private int toPixel(int n) {
        return n * ((SimpleGfxGrid) getGrid()).getCellSize();
    }

    /**
     * Utility that gets the n integer converted to rows
     *
     * @param n integer to be converted
     * @return Row value of integer n
     */
    private int toRows(int n) {
        return n / (((SimpleGfxGrid) getGrid()).getCellSize());
    }

    /**
     * Condition to move the object until the max lower size of the grid
     * (used to stop moving when reaches it)
     *
     * @param distance the number of positions that the object might move
     * @return if reached the most lower point of the grid
     */
    public boolean moveDown(int distance) { // TODO: 31/05/16 check the problem in the cols & rows
        int maxRowsDown = 0;

        if (shape instanceof Movable) {

            int shapeHeight = shape.getHeight() / ((SimpleGfxGrid) getGrid()).getCellSize();
            maxRowsDown = distance > (getGrid().getRows() - (getRow() + shapeHeight)) ?
                    getGrid().getRows() - (getRow() + shapeHeight) : distance;

            setPos(0, maxRowsDown);
        }

            return !(maxRowsDown == 0);

    }

    /**
     * Condition to move the object until the max upper size of the grid
     * (used to stop moving when reaches it)
     *
     * @param distance the number of positions that the object might move
     * @return if reached the most upper point of the grid
     */
    public boolean moveUp(int distance) {
        int maxRowsUp = 0;

        if (shape instanceof Movable) {
            maxRowsUp = distance < getRow() ? distance : getRow();
            setPos(0, -maxRowsUp);
        }

        return !(maxRowsUp == 0);
    }

    /**
     * Condition to move the object until the max west size of the grid
     * (used to stop moving when reaches it)
     *
     * @param distance the number of positions that the object might move
     * @return if reached the most western point of the grid
     */
    public boolean moveLeft(int distance) {
        int maxColsLeft = 0;
        if (shape instanceof Movable) {
            maxColsLeft = distance < getCol()  ? distance : getCol();
            setPos(-maxColsLeft, 0);
        }
        return !(maxColsLeft == 0);

    }

    /**
     * Condition to move the object until the max east size of the grid
     * (used to stop moving when reaches it)
     *
     * @param distance the number of positions that the object might move
     * @return if reached the most eastern point of the grid
     */
    public boolean moveRight(int distance) {
        int maxColsRight = 0;

        if (shape instanceof Movable) {

            int shapeWidth = shape.getWidth() / ((SimpleGfxGrid) getGrid()).getCellSize();

            maxColsRight = distance > (getGrid().getCols() - (getCol() + shapeWidth)) ?
                    getGrid().getCols() - (getCol() + shapeWidth) : distance;

            setPos(maxColsRight, 0);

        }
        return !(maxColsRight == 0);
    }

    /**
     * Updates the shape position on the grid
     *
     * @param deltaCol distance the object will be moved in cols
     * @param deltaRow distance the object will be moved in rows
     */
    @Override
    public void setPos(int deltaCol, int deltaRow) {

        if (shape instanceof Movable) {
            super.setPos(getCol() + deltaCol, getRow() + deltaRow);
            ((Movable) shape).translate(toPixel(deltaCol), toPixel(deltaRow));

        }
    }

    /**
     * Updates the shape according to direction that the object will have
     *
     * @param direction
     * @param objType type of object that will get its shape updated
     */
    @Override
    public void replace(GridDirection direction, GameObjectType objType) {

        Shape tempShape;

        switch(direction) {


            case UP:
                tempShape = factory.createShape(shape, objType, GridDirection.UP);
                hide();
                shape = tempShape;
                show();
                break;

            case DOWN:
                tempShape = factory.createShape(shape, objType, GridDirection.DOWN);
                hide();
                shape = tempShape;
                show();
                break;

            case RIGHT:
                tempShape = factory.createShape(shape, objType, GridDirection.RIGHT);
                hide();
                shape = tempShape;
                show();
                break;

            case LEFT:
                tempShape = factory.createShape(shape, objType, GridDirection.LEFT);
                hide();
                shape = tempShape;
                show();
                break;

        }


    }

    //@Override
    //public boolean isAdjacent(GridPosition position) {
      //  return super.isAdjacent(position);
    //}

    @Override
    public void show() {
        shape.draw();
    }

    @Override
    public void hide() {

        shape.delete();
    }


}
