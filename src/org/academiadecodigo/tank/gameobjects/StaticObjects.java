package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public class StaticObjects extends GameObjects {
    @Override
    public void hit() {

    }

    public StaticObjects(GridPosition position){
        super(position);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public void setDestroyed() {

    }

}
