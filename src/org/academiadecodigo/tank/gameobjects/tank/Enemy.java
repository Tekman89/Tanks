package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.utilities.RNG;

/**
 * Created by codecadet on 23/05/16.
 */


/**
 * Specify Enemy class from Tanks
 *
 * @Constant PROBABILITY set the scope of the Random Generator
 */
public class Enemy extends Tank {


    private final int PROBABILITY = 10;

    /**
     * Constructs a new Enemy
     *
     * @param pos initial Enemy position in the grid
     * @param collision  Check the state of collision
     */
    public Enemy(GridPosition pos, Colision collision) {
        super(pos, collision);
    }

/**
 * Get a random direction on the grid to the Enemy
 *
 * @return corresponding Grid direction for the Enemy to move
*/

    private GridDirection chooseDirection() {

        switch (RNG.rng(4)) {
            case 0:
                if (getDirection() != GridDirection.UP) {
                    getPos().replace(GridDirection.UP, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.UP);
                return GridDirection.UP;

            case 1:
                if (getDirection() != GridDirection.DOWN) {
                    getPos().replace(GridDirection.DOWN, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.DOWN);
                return GridDirection.DOWN;

            case 2:
                if (getDirection() != GridDirection.RIGHT) {
                    getPos().replace(GridDirection.RIGHT, GameObjectType.ENEMY);

                }
                super.setDirection(GridDirection.RIGHT);
                return GridDirection.RIGHT;

            case 3:
                if (getDirection() != GridDirection.LEFT) {
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

        if (RNG.rng(PROBABILITY) < 2 || super.getDirection() == null) {

            super.setDirection(chooseDirection());

        }

        return super.move();

    }

}


