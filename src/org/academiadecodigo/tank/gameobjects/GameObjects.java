package org.academiadecodigo.tank.gameobjects;

import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGridPosition;

/**
 * Created by codecadet on 23/05/16.
 */

/**
 * Is the base skeleton for Tank and Shell
 */
public abstract class GameObjects implements Destroyable {


    private boolean isDestroyed;
    private GridPosition pos;

    /**
     * Constructs new GameObjects
     *
     * @param pos initial GameObjects position in the grid
     */
    public GameObjects(GridPosition pos){
        this.pos = pos;
    }

    /**
     * Gets the position on the grid
     *
     * @return a position on the grid
     */
    public GridPosition getPos() {
        return pos;
    }

    /**
     * Update the destroyed value to true
     */
    @Override
    public void setDestroyed() {
        isDestroyed = true;
    }

    /**
     * @return isDestroyed value
     */
    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }
}
