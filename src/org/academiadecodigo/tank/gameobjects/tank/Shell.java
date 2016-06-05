package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.Collision;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class Shell extends GameObjects implements MovableDestroyable{

    private Tank myTank;
    private GridDirection direction;
    private final int SPEED = 1;
    private Collision collision;

    public Shell (GridPosition pos, Tank tank, Collision collision){
        super(pos);
        this.myTank = tank;
        this.collision = collision;

        if(tank.getDirection() == GridDirection.STILL) {

            this.direction = myTank.getPreviousDirection();
        } else {

            this.direction = myTank.getDirection();
        }
    }

    public Tank whoFired() {
        return myTank;
    }

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



    public boolean sameType(GameObjects object){

        return object instanceof Tank && myTank.getMyType() == ((Tank) object).getMyType();
    }


    @Override
    public GridDirection getDirection() {
        return direction;
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
