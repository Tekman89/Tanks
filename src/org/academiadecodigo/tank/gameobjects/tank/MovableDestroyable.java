package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.grid.GridDirection;
import org.academiadecodigo.tank.gameobjects.Destroyable;

/**
 * Created by codecadet on 30/05/16.
 */
public interface MovableDestroyable extends Destroyable {



        boolean move();

        GridDirection getDirection();






}
