package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 24/05/16.
 */
public class SimpleGfxGrid  implements Grid{


    private Rectangle grid;
    private int cols;
    private int rows;

    private int CELL_SIZE = 1;


    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        grid = new Rectangle(0, 0, cols * CELL_SIZE, rows * CELL_SIZE);
    }



    @Override
    public void init() {
        grid.setColor(Color.GRAY);
        grid.fill();
    }

    @Override
    public int getCols() {
        return cols;
    }

    @Override
    public int getRows() {
        return rows;
    }

    public int getCellSize() { return CELL_SIZE; }

    @Override
    public GridPosition makeGridPosition() {
        int 
        return new SimpleGfxGridPosition();
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return null;
    }
}
