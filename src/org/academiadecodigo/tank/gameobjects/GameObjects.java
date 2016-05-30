package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;

/**
 * Created by codecadet on 23/05/16.
 */
public abstract class GameObjects implements Destroyable {

    private AbstractGridPosition pos;
    // size

    public void move(int col, int row){

    }
    public AbstractGridPosition getPos() {
        return pos;
    }

}
