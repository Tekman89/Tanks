package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Tank extends GameObjects implements MovableDestroyable {

    public static final int SPEED = 1;
    private GridDirection direction = GridDirection.DOWN;
    private GridDirection previousDirection = GridDirection.UP;
    private int movesMade;
    private boolean safeMove;
    protected GameObjectType myType;

    private Colision collision;


    public Tank(GridPosition pos, Colision collision) {
        super(pos);
        this.collision = collision;
    }

    @Override
    public boolean move() {

        collision.isSafe(this);

        if (safeMove) {
            movesMade++;


        }else {
            setDirection(direction.oppositeDirection());
            movesMade++;
        }

        return getPos().move(direction, SPEED);
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



    protected int getMovesMade() {
        return movesMade;
    }

    public void setSafeMove(boolean safeMove) {
        this.safeMove = safeMove;
    }

    public boolean isSafeMove() {
        return safeMove;
    }

    public GameObjectType getMyType() {
        return myType;
    }


    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void setDestroyed() {
        super.setDestroyed();
    }

    public boolean fire() {

         return super.getPos().getCol() > 0 && super.getPos().getCol() < super.getPos().getGrid().getCols() - super.getPos().getWidth() &&
                    super.getPos().getRow() > 0 && super.getPos().getRow() < super.getPos().getGrid().getRows() - super.getPos().getHeight();
    }

    @Override
    public String toString() {
        return "Tank{" +
                "myType=" + myType +
                '}';
    }
}
