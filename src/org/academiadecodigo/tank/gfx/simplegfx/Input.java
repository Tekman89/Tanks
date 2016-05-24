package org.academiadecodigo.tank.gfx.simplegfx;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 24/05/16.
 */
public abstract class Input implements KeyboardHandler {

    private Keyboard myKey = new Keyboard(this);
    private KeyboardEvent leftPress = new KeyboardEvent();
    private KeyboardEvent downPress = new KeyboardEvent();
    private KeyboardEvent rightPress = new KeyboardEvent();
    private KeyboardEvent upPress = new KeyboardEvent();
    private KeyboardEvent spacePress = new KeyboardEvent();
    private KeyboardEvent spaceRelease = new KeyboardEvent();


    public void setEvent(){

        /*
         * set the event types
         */


        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);


        /*
         * set the keys for those events
         */


        leftPress.setKey(KeyboardEvent.KEY_LEFT);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);
        upPress.setKey(KeyboardEvent.KEY_UP);
        downPress.setKey(KeyboardEvent.KEY_DOWN);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);

        /*
         * set the listeners
         */

        myKey.addEventListener(leftPress);
        myKey.addEventListener(rightPress);
        myKey.addEventListener(upPress);
        myKey.addEventListener(downPress);
        myKey.addEventListener(spacePress);
        myKey.addEventListener(spaceRelease);


    }





    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_LEFT:

                break;
            case KeyboardEvent.KEY_RIGHT:

                break;
            case KeyboardEvent.KEY_UP:

                break;
            case KeyboardEvent.KEY_DOWN:

                break;
            case KeyboardEvent.KEY_SPACE:

                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_SPACE:

                break;
        }

    }
}
