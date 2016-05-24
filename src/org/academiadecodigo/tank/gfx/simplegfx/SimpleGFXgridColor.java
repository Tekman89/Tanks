package org.academiadecodigo.tank.gfx.simplegfx;
import org.academiadecodigo.tank.grid.GridColor;
import org.academiadecodigo.simplegraphics.graphics.Color;
import java.util.EnumMap;
import java.util.Map;


/**
 * Created by codecadet on 24/05/16.
 */
public class SimpleGFXgridColor {

        private static final Map<GridColor, Color> colorMap = new EnumMap<GridColor, Color>(GridColor.class);

        static {

            colorMap.put(GridColor.BLUE, Color.BLUE);
            colorMap.put(GridColor.GREEN, Color.GREEN);
            colorMap.put(GridColor.RED, Color.RED);
            colorMap.put(GridColor.MAGENTA, Color.MAGENTA);

        }

        public static Color getColor(GridColor color) {
            return colorMap.get(color);
        }

    }


