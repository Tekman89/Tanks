package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 04/06/16.
 */
public class Brick extends GameObjects {


    public Brick (GridPosition position) {
        super(position);
    }

    @Override
    public void hit() {
        super.setDestroyed();
    }
}
