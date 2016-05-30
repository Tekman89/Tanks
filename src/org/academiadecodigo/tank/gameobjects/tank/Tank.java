package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Tank extends GameObjects implements MovableDestroyable {

    private boolean isDestroyed;
    public static final int SPEED = 1;
    private GridDirection direction;



    public Tank(GridPosition pos) {
        super(pos);
    }


    public GridDirection getDirection() {
        return direction;
    }

    public void setDirection(GridDirection direction) {
        this.direction = direction;
    }

    @Override
    public void hit() {
       // pos.hide();
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }




}
