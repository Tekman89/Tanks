package org.academiadecodigo.tank.gameobjects.tank;

import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.tank.TankType;

/**
 * Created by codecadet on 23/05/16.
 */
public class Shell extends GameObjects {

    private TankType myTank;

    public Shell (TankType myTank){

        this.myTank = myTank;
    }

    public TankType whoFired() {
        return myTank;
    }

}
