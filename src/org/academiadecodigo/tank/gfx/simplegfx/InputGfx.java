package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.tank.grid.GridDirection;

/**
 * Created by codecadet on 24/05/16.
 */
public class InputGfx implements KeyboardHandler, org.academiadecodigo.tank.utilities.Input {

    private Keyboard myKey = new Keyboard(this);
    private KeyboardEvent leftPress = new KeyboardEvent();
    private KeyboardEvent downPress = new KeyboardEvent();
    private KeyboardEvent rightPress = new KeyboardEvent();
    private KeyboardEvent upPress = new KeyboardEvent();
    private KeyboardEvent spacePress = new KeyboardEvent();
    private KeyboardEvent leftReleased = new KeyboardEvent();
    private KeyboardEvent rightReleased = new KeyboardEvent();
    private KeyboardEvent upReleased = new KeyboardEvent();
    private KeyboardEvent downReleased = new KeyboardEvent();
    private KeyboardEvent spaceRelease = new KeyboardEvent();
    private GridDirection direction = GridDirection.STILL;
    private boolean fire;


    public InputGfx() {
        setEvent();
    }


    public void setEvent() {

        /*
         * set the event types
         */


        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        /*
         * set the keys for those events
         */


        leftPress.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        upPress.setKey(KeyboardEvent.KEY_UP);
        upReleased.setKey(KeyboardEvent.KEY_UP);
        downPress.setKey(KeyboardEvent.KEY_DOWN);
        downReleased.setKey(KeyboardEvent.KEY_DOWN);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);

        /*
         * set the listeners
         */

        myKey.addEventListener(leftPress);
        myKey.addEventListener(leftReleased);
        myKey.addEventListener(rightPress);
        myKey.addEventListener(rightReleased);
        myKey.addEventListener(upPress);
        myKey.addEventListener(upReleased);
        myKey.addEventListener(downPress);
        myKey.addEventListener(downReleased);
        myKey.addEventListener(spacePress);
        myKey.addEventListener(spaceRelease);


    }


    public GridDirection getDirection() {

        return this.direction;

    }

    public boolean getFire(){
        return fire;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_LEFT:
                direction = GridDirection.LEFT;
                break;
            case KeyboardEvent.KEY_RIGHT:
                direction = GridDirection.RIGHT;
                break;
            case KeyboardEvent.KEY_UP:
                direction = GridDirection.UP;
                break;
            case KeyboardEvent.KEY_DOWN:
                direction = GridDirection.DOWN;
                break;
            case KeyboardEvent.KEY_SPACE:
                fire = true;
                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch(keyboardEvent.getKey()){

            case KeyboardEvent.KEY_LEFT:

            case KeyboardEvent.KEY_RIGHT:

            case KeyboardEvent.KEY_UP:

            case KeyboardEvent.KEY_DOWN:
                direction = GridDirection.STILL;
                break;
            case KeyboardEvent.KEY_SPACE:
                fire = false;
                break;
        }

    }

}

