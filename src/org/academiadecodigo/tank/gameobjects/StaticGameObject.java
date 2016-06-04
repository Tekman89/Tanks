package org.academiadecodigo.tank.gameobjects;


import org.academiadecodigo.tank.grid.position.AbstractGridPosition;
import org.academiadecodigo.tank.grid.position.GridPosition;

/**
 * Created by codecadet on 04/06/16.
 */
public class StaticGameObject extends GameObjects {

    GameObjectType gameObjectType;


    public StaticGameObject (GridPosition position, GameObjectType myType){
        super(position);
        this.gameObjectType = myType;
    }

    @Override
    public void hit() {
        super.setDestroyed();
    }


}
