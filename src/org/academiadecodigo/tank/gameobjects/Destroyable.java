package org.academiadecodigo.tank.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Destroyable {

    void hit();

    /**
     *  Get whether the object is destroyed
     *
     * @return true if destroyed
     */
    boolean isDestroyed();

    /**
     * Update the destroyed value
     */
    void setDestroyed();

}
