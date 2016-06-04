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
    private final int SPEED = 1;

    public Shell (GridPosition pos, Tank tank){
        super(pos);
        this.myTank = tank;

        if(tank instanceof Player) {
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
        return getPos().move(direction, SPEED);
    }



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

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void setDestroyed() {
        super.setDestroyed();
    }


}
