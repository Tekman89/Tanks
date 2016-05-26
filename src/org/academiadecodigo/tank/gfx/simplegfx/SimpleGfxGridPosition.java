package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private int col;
    private int row;
    private Shape shape;

    public SimpleGfxGridPosition (int col, int row, SimpleGfxGrid grid){

        super(col, row, grid);

        //shape = some shape

    }

    private int toPixel(int n){
        return n * ((SimpleGfxGrid)getGrid()).getCellSize();
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }


    public void 


    @Override
    public void setPos(int col, int row) {

    }

    @Override
    public void show() {
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
