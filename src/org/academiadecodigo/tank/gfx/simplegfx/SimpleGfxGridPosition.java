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
    ShapeFactory factory = new ShapeFactory();

    public SimpleGfxGridPosition(int col, int row, GameObjectType objectType, SimpleGfxGrid grid) {

        super(col, row, grid);
        shape = factory.createShape(toPixel(col) + grid.getMARGIN(), toPixel(row) + grid.getMARGIN(), objectType, grid);
        show();
        super.setHeight(toRows(shape.getHeight()));
        super.setWidth(toRows(shape.getWidth()));

    }

    private int toPixel(int n) {
        return n * ((SimpleGfxGrid) getGrid()).getCellSize();
    }

    private int toRows(int n) {
        return n / (((SimpleGfxGrid) getGrid()).getCellSize());
    }


    public boolean moveDown(int distance) { // TODO: 31/05/16 check the problem in the cols & rows
        int maxRowsDown = 0;
        if (shape instanceof Movable) {

            int shapeHeight = shape.getHeight() / ((SimpleGfxGrid) getGrid()).getCellSize();
            maxRowsDown = distance > (getGrid().getRows() + toRows(getGrid().getMARGIN()) - (getRow() + shapeHeight)) ?
                    getGrid().getRows() + toRows(getGrid().getMARGIN()) - (getRow() + shapeHeight) :
                    distance;
            setPos(0, maxRowsDown);
        }

        System.out.println(maxRowsDown);
            return !(maxRowsDown == 0);

    }

    public boolean moveUp(int distance) {
        int maxRowsUp = 0;
        if (shape instanceof Movable) {
            maxRowsUp = distance < getRow() - toRows(getGrid().getMARGIN()) ? distance : getRow() - toRows(getGrid().getMARGIN() );
            setPos(0, -maxRowsUp);
        }
        return !(maxRowsUp == 0);
    }

    public boolean moveLeft(int distance) {
        int maxColsLeft = 0;
        if (shape instanceof Movable) {
            maxColsLeft = distance < getCol() - toRows(getGrid().getMARGIN()-1) ? distance : getCol() - toRows(getGrid().getMARGIN() -1);
            setPos(-maxColsLeft, 0);
        }
        return !(maxColsLeft == 0);

    }

    public boolean moveRight(int distance) {
        int maxColsRight = 0;
        if (shape instanceof Movable) {

            int shapeWidth = shape.getWidth() / ((SimpleGfxGrid) getGrid()).getCellSize();

            maxColsRight = distance > (getGrid().getCols() + toRows(getGrid().getMARGIN()-1) - (getCol() + shapeWidth)) ?
                    getGrid().getCols() + toRows(getGrid().getMARGIN()-1) - (getCol() + shapeWidth) : distance;

            setPos(maxColsRight, 0);

        }
        return !(maxColsRight == 0);
    }

    @Override
    public void setPos(int deltaCol, int deltaRow) {

        if (shape instanceof Movable) {
            super.setPos(getCol() + deltaCol, getRow() + deltaRow);
            ((Movable) shape).translate(toPixel(deltaCol), toPixel(deltaRow));

        }
    }
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

    @Override
    public void show() {
        /*if(shape instanceof Rectangle) {
            ((Rectangle) shape).setColor(Color.BLUE);
            ((Rectangle) shape).fill();
        }*/
        shape.draw();

    }

    @Override
    public void hide() {

        shape.delete();
    }



    /*@Override
    public boolean isAdjacent(AbstractGridPosition position) {


        return false;
    }*/
}
