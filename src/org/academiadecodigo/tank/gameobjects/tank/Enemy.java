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



    public Enemy(GridPosition pos){
        super(pos);
    }


    private GridDirection chooseDirection (){

        switch (RNG.rng(4)){
            case 0 :
                System.out.println("UP");
                if(getDirection() != GridDirection.UP){
                    getPos().replace(GridDirection.UP, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.UP);
                return GridDirection.UP;

            case 1 :
                System.out.println("Down");
                super.setDirection(GridDirection.DOWN);
                return GridDirection.DOWN;

            case 2 :
                System.out.println("Right");
                super.setDirection(GridDirection.RIGHT);
                return GridDirection.RIGHT;

            case 3 :
                System.out.println("Left");
                super.setDirection(GridDirection.LEFT);
                return GridDirection.LEFT;

            default:
                System.out.println("Something went wrong");
                return null;
        }

    }

    @Override
    public void move() {
        System.out.println(getPos());
        super.
                getPos().
                moveInDirection(
                        chooseDirection(),
                        SPEED);
    }

    @Override
    public void setDestroyed() {

    }
}
