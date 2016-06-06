package org.academiadecodigo.tank.utilities;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;

/**
 * Created by codecadet on 27/05/16.
 */

/**
 * Creates new environment items
 */
public interface Factory {


    GameObjects createEnvironment(int col, int row, GameObjectType brick);
}
