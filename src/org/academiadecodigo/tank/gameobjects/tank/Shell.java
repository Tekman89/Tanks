package org.academiadecodigo.tank.gameobjects.tank;

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
    private final int SPEED = 4;

    /**
     * Constructs a new Shell
     *
     * @param pos initial Shell position in the grid
     * @param tank connect the Shell with a Tank type
     */
    public Shell (GridPosition pos, Tank tank){
        super(pos);
        this.myTank = tank;
        this.direction = myTank.getPreviousDirection();//See #move()

    }

    public Tank whoFired() {
        return myTank;
    }

    /**
     * Condition for the Shell fetch Player direction
     *
     * @return the direction and speed of the Shell
     */
    public boolean move(){

        if(myTank instanceof Player && direction == GridDirection.STILL){

            Player player = (Player) myTank;
            direction = player.getPreviousDirection();

        }
        return getPos().move(direction, SPEED);//TODO-Comment- rephrase the doc
    }

    @Override
    public GridDirection getDirection() {
        return direction;
    }

    @Override
    public void hit() {//TODO-Comment- see if the method is used.

    }

//    public boolean onEdge(){
//
//        System.out.println(getPos().onEdge());
//        return getPos().onEdge();
//    }

    /**
     * @return //TODO-Comment-
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
