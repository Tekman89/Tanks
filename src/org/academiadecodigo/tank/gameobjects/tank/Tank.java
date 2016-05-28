package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Tank extends GameObjects implements Movable {

    private GridPosition pos;
    private boolean isDestroyed;

    @Override
    public void hit() {
        pos.hide();
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void setDestroyed() {
        this.isDestroyed = true;
    }
}
