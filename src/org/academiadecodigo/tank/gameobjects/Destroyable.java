package org.academiadecodigo.tank.gameobjects;

/**
 * Created by codecadet on 23/05/16.
 */
public interface Destroyable {

    void hit();

    boolean isDestroyed();

    void destroyed();

}
