package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.utilities.RNG;

/**
 * Created by codecadet on 23/05/16.
 */
public class Enemy extends Tank {


    private final int PROBABILITY = 10;



    public Enemy(GridPosition pos){
        super(pos);
    }


    private GridDirection chooseDirection (){

        switch (RNG.rng(4)){
            case 0 :
                if(getDirection() != GridDirection.UP){
                    getPos().replace(GridDirection.UP, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.UP);
                return GridDirection.UP;

            case 1 :
                if(getDirection() != GridDirection.DOWN){
                    getPos().replace(GridDirection.DOWN, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.DOWN);
                return GridDirection.DOWN;

            case 2 :
                if(getDirection() != GridDirection.RIGHT){
                    getPos().replace(GridDirection.RIGHT, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.RIGHT);
                return GridDirection.RIGHT;

            case 3 :
                if(getDirection() != GridDirection.LEFT){
                    getPos().replace(GridDirection.LEFT, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.LEFT);
                return GridDirection.LEFT;

            default:
                System.out.println("Something went wrong");
                return null;
        }

    }

    /**
     * Weight defined to choose a new direction
     */

    @Override
    public boolean move() {

        if(RNG.rng(PROBABILITY) < 2 || super.getDirection() == null) {
           // System.out.println(getPos());
            return super.getPos().move(chooseDirection(), SPEED);

        } else {

            return super.getPos().move(super.getDirection(),SPEED);
        }

    }

    @Override
    public void setDestroyed() {

    }
}
