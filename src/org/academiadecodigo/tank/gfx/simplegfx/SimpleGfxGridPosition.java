package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
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
        shape = factory.createShape(toPixel(col), toPixel(row), objectType) ;
        show();

    }

    private int toPixel(int n){
        return n * ((SimpleGfxGrid)getGrid()).getCellSize();
    }


    public void moveDown(int distance) {

        if (shape instanceof Movable) {

            int maxRowsDown = distance > getGrid().getRows() - (getRow() + 1) ? getGrid().getRows() - (getRow() + 1) : distance;
            ((Movable) shape).translate(0, toPixel(maxRowsDown));
            setPos(getCol(), getRow() + maxRowsDown);

        }
    }

    public  void moveUp(int distance) {

        if (shape instanceof Movable) {
            int maxRowsUp = distance < getRow() ? distance : getRow();
            ((Movable) shape).translate(0, toPixel(-maxRowsUp));
            setPos(getCol(), getRow() - maxRowsUp);
        }
    }

    public void moveLeft(int distance) {

        if (shape instanceof Movable) {

            int maxColsLeft = distance < getCol() ? distance : getCol();
            ((Movable) shape).translate(- toPixel(maxColsLeft), 0);
            setPos(getCol() - maxColsLeft, getRow());
        }

    }

    public void moveRight(int distance) {

        if (shape instanceof Movable) {

            int maxColsRight = distance > getGrid().getCols() - (getCol() + 1) ? getGrid().getCols() - (getCol()+1) : distance;
            ((Movable) shape).translate(toPixel(maxColsRight),0);
            setPos(getCol() + maxColsRight, getRow());

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

    @Override
    public boolean equals(AbstractGridPosition position) {
        return false;
    }
}
