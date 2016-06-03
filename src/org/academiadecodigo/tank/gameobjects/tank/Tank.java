package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Tank extends GameObjects implements MovableDestroyable {

    public static final int SPEED = 1;
    private GridDirection direction = GridDirection.STILL;
    private GridDirection previousDirection = GridDirection.UP;

    private Colision collision;



    public Tank(GridPosition pos, Colision collision) {
        super(pos);
        this.collision = collision;
    }

    @Override
    public boolean move() {

        if(collision.isSafe(this)){

          return  getPos().move(direction, SPEED);

        }
        return getPos().move(direction.oppositeDirection(), SPEED);
    }

    @Override
    public GridDirection getDirection() {
        return direction;
    }

    public GridDirection getPreviousDirection() {
        return previousDirection;
    }

    protected void setDirection(GridDirection direction) {
        this.direction = direction;
    }

    protected void setPreviousDirection(GridDirection direction) {

        if (direction != GridDirection.STILL && direction != null) {
            this.previousDirection = direction;
        }
    }


    @Override
    public void hit() {
       //pos.hide();
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void setDestroyed() {
        super.setDestroyed();
    }
}
