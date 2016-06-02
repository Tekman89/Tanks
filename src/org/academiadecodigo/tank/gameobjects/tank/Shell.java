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

    private boolean isDestroyed;
    private Tank myTank;
    private GridDirection direction;
    private final int SPEED = 4;

    public Shell (GridPosition pos, Tank tank){
        super(pos);
        this.myTank = tank;
        this.direction = myTank.getPreviousDirection();
        //System.out.println(getPos());

    }

    public Tank whoFired() {
        return myTank;
    }

    public boolean move(){

        if(myTank instanceof Player && direction == GridDirection.STILL){

            Player player = (Player) myTank;
            direction = player.getPreviousDirection();
            //System.out.println(((AbstractGridPosition) getPos()).getHeight() + " " + ((AbstractGridPosition) getPos()).getWidth());


        }
        //System.out.println("shell " + getPos());
        return getPos().move(direction, SPEED);
    }

    @Override
    public void hit() {


    }

//    public boolean onEdge(){
//
//        System.out.println(getPos().onEdge());
//        return getPos().onEdge();
//    }



    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void setDestroyed() {
        isDestroyed = true;
    }


}
