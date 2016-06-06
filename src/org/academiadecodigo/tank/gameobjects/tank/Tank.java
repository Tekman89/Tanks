package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */

/**
 * Base skelleton for the Player and Enemy
 *
 * @see Player
 * @see Enemy
 */
public abstract class Tank extends GameObjects implements MovableDestroyable {

    public static final int SPEED = 1;
    private GridDirection direction = GridDirection.STILL;
    private GridDirection previousDirection = GridDirection.UP;
    private int movesMade;
    private boolean safeMove;
    protected GameObjectType myType;

    private Colision collision;

    /**
     * Construct Tank class
     *
     * @param pos initial Tank position in the grid
     * @param collision Check the state of collision
     */
    public Tank(GridPosition pos, Colision collision) {
        super(pos);
        this.collision = collision;
    }

    /**
     * Check if already exists an object in the position the Tank wants to move or it
     * came across the grid limit
     *
     * @return if false move the object on the opposite direction, move in the given direction
     */

    @Override
    public boolean move() {

        collision.isSafe(this);

        if (safeMove) {
            movesMade++;
            return getPos().move(direction, SPEED);

        }

        return getPos().move(direction.oppositeDirection(),SPEED);
    }

    /**
     * @return a new direction
     */
    @Override
    public GridDirection getDirection() {
        return direction;
    }

    /**
     * @return a new direction that is the previous one
     */
    public GridDirection getPreviousDirection() {
        return previousDirection;
    }

    /**
     * Assign a grid direction as property
     *
     * @param direction of GridDirection type
     */
    protected void setDirection(GridDirection direction) {
        this.direction = direction;
    }

    /**
     * Assign a grid direction different from Null as previous direction(gets rid of null pointer exception)
     *
     * @param direction
     */
    protected void setPreviousDirection(GridDirection direction) {

        if (direction != GridDirection.STILL && direction != null) {
            this.previousDirection = direction;
        }
    }



    protected int getMovesMade() {
        return movesMade;
    }

    public void setSafeMove(boolean safeMove) {//TODO-comment- Ver a o que isto faz
        this.safeMove = safeMove;
    }

    public boolean isSafeMove() {
        return safeMove;
    }

    public GameObjectType getMyType() {
        return myType;
    }

    @Override
    public void hit() {
        //pos.hide();
    }

    /**
     *
     * @see GameObjects#isDestroyed()
     */
    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    /**
     * @see GameObjects#setDestroyed()
     */
    @Override
    public void setDestroyed() {
        super.setDestroyed();
    }

    /**
     * Restricts the Tank fire in the grid limit
     *
     * @return if true the tank will fire
     */
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
