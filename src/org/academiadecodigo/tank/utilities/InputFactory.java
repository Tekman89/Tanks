package org.academiadecodigo.tank.utilities;

import org.academiadecodigo.tank.gfx.simplegfx.InputGfx;

/**
 * Created by codecadet on 02/06/16.
 */
public final class InputFactory {


    public static Input newInput(InputType inputType){

        switch (inputType){


            case SIMPLEGFX:
            default:
                return new InputGfx();
        }


    }



}
