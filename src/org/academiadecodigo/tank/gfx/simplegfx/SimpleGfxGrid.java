package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.tank.Tank;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 24/05/16.
 */
public class SimpleGfxGrid  implements Grid {


    private Shape grid;
    private int cols;
    private int rows;
    private final int MARGIN = 10;
    private int counter;


    private final int CELL_SIZE = MARGIN / 2;


    public SimpleGfxGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        grid = new Rectangle(MARGIN, MARGIN, cols * CELL_SIZE, rows * CELL_SIZE);
    }

    public SimpleGfxGrid(){
        grid = new Picture(MARGIN,MARGIN, "images/Background.png");
        cols = grid.getWidth()/CELL_SIZE;
        rows = grid.getHeight()/CELL_SIZE;
    }


    @Override
    public void init() {
        grid.draw();
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
    public GridPosition makeGridPosition(int col, int row, GameObjectType objectType) {
        return new SimpleGfxGridPosition(col, row, objectType, this);

    }

    @Override
    public GridPosition makeGridPosition(GameObjectType objectType) {

        switch(objectType) {

            case ENEMY:
                return new SimpleGfxGridPosition(generateCol(), generateRow(), objectType, this);

            case PLAYER:
                return new SimpleGfxGridPosition(cols/2 - 3, rows - 6, objectType, this); // the 3 is the half the width and the 6 is all the width

            case BRICK:
                return new SimpleGfxGridPosition(40,40,objectType, this);

            case GOAL:
                return new SimpleGfxGridPosition(cols/2 - 6, 0, objectType, this); // the 6 is half the width of the goal target

            default:
                return null;
        }

    }

    @Override
    public GridPosition makeGridPosition(GameObjectType objectType, Tank myTank){

        switch (objectType){

            case SHELL:

                return shellDirection(myTank);

            default:
                System.out.println("Pos bug");
                return null;
        }

    }


    private GridPosition shellDirection(Tank myTank){


        GridDirection directionToGo = myTank.getDirection() == GridDirection.STILL ? myTank.getPreviousDirection() : myTank.getDirection();

        switch (directionToGo){

            case UP:
                return new SimpleGfxGridPosition(myTank.getPos().getCol() + myTank.getPos().getWidth()/2,
                        myTank.getPos().getRow()-1,
                        GameObjectType.SHELL, this);
            case DOWN:
                return new SimpleGfxGridPosition(myTank.getPos().getCol() + myTank.getPos().getWidth()/2,
                        myTank.getPos().getRow()+ 1 + myTank.getPos().getHeight(),
                        GameObjectType.SHELL, this);
            case LEFT:
                return new SimpleGfxGridPosition(myTank.getPos().getCol() -1,
                        myTank.getPos().getRow() + myTank.getPos().getHeight()/2,
                        GameObjectType.SHELL, this);
            case RIGHT:
                return new SimpleGfxGridPosition(myTank.getPos().getCol()+1 + myTank.getPos().getWidth(),
                        myTank.getPos().getRow() + myTank.getPos().getHeight()/2,
                        GameObjectType.SHELL, this);
            default:
                System.out.println("Problem in the shellDirection/SimpleGfxGrid");
                return null;

        }

    }


    private int generateCol() {




        switch (counter%2) {

            case 0:
                return 0;
            case 1:
                return cols - 6;
            default:
                System.out.println("Something went wrong with the rng");
                return 0;

        }

    }

    private int generateRow(){



        switch (counter%2) {



            case 0:
                counter++;
                return rows/4;
            case 1:
                counter++;
                return rows - rows/4;

            default:
                System.out.println("Something went wrong with the rng");
                return 0;

        }

    }
}
