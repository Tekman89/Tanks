package org.academiadecodigo.tank.grid;

/**
 * Created by codecadet on 23/05/16.
 */
public enum GridDirection {

    UP,
    DOWN,
    LEFT,
    STILL,
    RIGHT;

    public GridDirection oppositeDirection() {
        switch (this) {

            case UP:
                return DOWN;

            case DOWN:
                return UP;

            case LEFT:
                return RIGHT;

            case RIGHT:
                return LEFT;

            default:
                return STILL;
        }
    }
}


