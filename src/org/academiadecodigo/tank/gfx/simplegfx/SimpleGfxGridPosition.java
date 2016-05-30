package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Shape shape;
    ShapeFactory factory = new ShapeFactory();

    public SimpleGfxGridPosition (int col, int row, GameObjectType objectType, SimpleGfxGrid grid){

        super(col, row, grid);
        shape = factory.createShape(toPixel(col) + grid.getMARGIN(), toPixel(row) + grid.getMARGIN(), objectType, grid) ;
        show();

    }

    private int toPixel(int n){
        return n * ((SimpleGfxGrid)getGrid()).getCellSize();
    }


    public void moveDown(int distance) {

        if (shape instanceof Movable) {

            int shapeHeight = shape.getHeight() / ((SimpleGfxGrid)getGrid()).getCellSize();
            int maxRowsDown = distance > getGrid().getRows() - (getRow() + shapeHeight) ? getGrid().getRows() - (getRow() + shapeHeight) : distance;
            setPos(0, maxRowsDown);
        }
    }

    public  void moveUp(int distance) {

        if (shape instanceof Movable) {
            int maxRowsUp = distance < getRow() ? distance : getRow();
            setPos(0, -maxRowsUp);
        }
    }

    public void moveLeft(int distance) {

        if (shape instanceof Movable) {
            int maxColsLeft = distance < getCol() ? distance : getCol();
            setPos(-maxColsLeft, 0);
        }

    }

    public void moveRight(int distance) {

        if (shape instanceof Movable) {

            int shapeWidth = shape.getWidth() / ((SimpleGfxGrid)getGrid()).getCellSize();
            int maxColsRight = distance > getGrid().getCols() - (getCol() + shapeWidth) ? getGrid().getCols() - (getCol() + shapeWidth) : distance;
            setPos(maxColsRight, 0);

        }
    }
    @Override
    public void setPos(int deltaCol, int deltaRow) {

        if(shape instanceof Movable) {
            super.setPos(getCol() + deltaCol, getRow() + deltaRow);
            ((Movable) shape).translate(toPixel(deltaCol), toPixel(deltaRow));

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
