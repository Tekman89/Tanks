package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Tank extends GameObjects implements Movable {

    private SimpleGfxGridPosition myRep;
    private boolean isDestroyed;

    @Override
    public void hit() {
        myRep.hide();
    }

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void destroyed() {
        this.isDestroyed = true;
    }
}
