package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.grid.Representation;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class Tank extends GameObjects implements Movable {

    private Representation myRep;

    @Override
    public void hit() {
        myRep.hide();
    }
}
