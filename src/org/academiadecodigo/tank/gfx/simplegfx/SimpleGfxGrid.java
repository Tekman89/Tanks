package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 24/05/16.
 */
public class SimpleGfxGrid  implements Grid {


    private Rectangle grid;
    private int cols;
    private int rows;
    private final int MARGIN = 10;

    private final int CELL_SIZE = MARGIN;


    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        grid = new Rectangle(MARGIN, MARGIN, cols * CELL_SIZE, rows * CELL_SIZE);
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

    public int getCellSize() {
        return CELL_SIZE;
    }

    @Override
    public int getMARGIN(){ return MARGIN;}

    @Override
    public GridPosition makeGridPosition(GameObjectType objectType) {

        switch(objectType) {

            case ENEMY:
                return new SimpleGfxGridPosition(1, 2, objectType, this);

            case PLAYER:
                return new SimpleGfxGridPosition(0,1, objectType, this); // TODO set player position


            default:
                return null;
        }

    }

    @Override
    public GridPosition makeGridPosition(GameObjectType objectType, Tank myTank){

        switch (objectType){

            case SHELL:
                System.out.println(myTank.getPos().getCol() * CELL_SIZE + " " + myTank.getPos().getRow() * CELL_SIZE);
                return new SimpleGfxGridPosition(myTank.getPos().getCol(), myTank.getPos().getRow(), objectType, this);

            default:
                System.out.println("Pos bug");
                return null;
        }

    }


    private int generateCol() {

        switch ((int) Math.floor(Math.random() * 3)) {

            case 0:
                return 0;
            case 1:
                return cols / 2;
            case 2:
                return cols - 1;
            default:
                System.out.println("Something went wrong with the rng");
                return -1;

        }

    }
}
