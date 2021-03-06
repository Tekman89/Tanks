package org.academiadecodigo.tank.utilities;

/**
 * Created by codecadet on 24/05/16.
 */

/**
 * Utility class that creates a Random Number Generator
 */
public abstract class RNG {

    public static int rng(int maxNumber){
        return (int) Math.floor(Math.random() * maxNumber);
    }

}
