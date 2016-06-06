package org.academiadecodigo.tank.gameobjects;


import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 04/06/16.
 */
public class StaticGameObject extends GameObjects {

    GameObjectType gameObjectType;

    /**
     * Constructs static game Objects
     *
     * @param position position on the grid of the created objects
     * @param myType the type of Object
     */
    public StaticGameObject (GridPosition position, GameObjectType myType){
        super(position);
        this.gameObjectType = myType;
    }

    /**
     * @see GameObjects#setDestroyed()
     */
    @Override
    public void hit() {
        super.setDestroyed();
    }


}
