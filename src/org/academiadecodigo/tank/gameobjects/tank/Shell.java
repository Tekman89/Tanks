package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Colision;
import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class Shell extends GameObjects implements MovableDestroyable{

    private Tank myTank;
    private GridDirection direction;
    private final int SPEED = 1;
    private Colision collision;

    /**
     * Constructs a new Shell and give it the direction of the tank
     *
     * @param pos initial Shell position in the grid
     * @param tank connect the Shell with a Tank type
     * @param collision set the reference for the collision object
     */
    public Shell (GridPosition pos, Tank tank, Colision collision){
        super(pos);
        this.myTank = tank;
        this.collision = collision;

        if(tank.getDirection() == GridDirection.STILL) {

            this.direction = myTank.getPreviousDirection();
        } else {

            this.direction = myTank.getDirection();
        }
    }

    /**
     *
     * @return the tank who fired
     */
    public Tank whoFired() {
        return myTank;
    }

    /**
     * Condition for the Shell fetch Tank direction
     * and ensures that the shell collides when hits the target
     * (remove the "teleportation" of the shell)
     *
     * @return the direction and speed of the Shell
     */
    public boolean move(){

        if(myTank instanceof Player && direction == GridDirection.STILL){

            Player player = (Player) myTank;
            direction = player.getPreviousDirection();

        }

        for (int i = 0; i < SPEED ; i++) {
            collision.checkHitTarget();
            getPos().move(direction,1);
        }

        return getPos().move(direction, 1);
    }

    /**
     * Compares if two objects are from the same type
     *
     * @param object that will be compared, its the type of GameObjects
     * @return if the objects are the same
     */
    public boolean sameType(GameObjects object){

        return object instanceof Tank && myTank.getMyType() == ((Tank) object).getMyType();
    }


    @Override
    public GridDirection getDirection() {
        return direction;
    }

    @Override
    public void hit() {
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


}
