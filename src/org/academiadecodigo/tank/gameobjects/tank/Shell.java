package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class Shell extends GameObjects {

    private boolean isDestroyed;
    private Tank myTank;

    public Shell (GridPosition position){
        super(position);
    }

    public Tank whoFired() {
        return myTank;
    }

    @Override
    public void hit() {


    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void setDestroyed() {
        isDestroyed = true;
    }


}
