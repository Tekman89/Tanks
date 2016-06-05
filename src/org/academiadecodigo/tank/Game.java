package org.academiadecodigo.tank;

import org.academiadecodigo.tank.gameobjects.GameObjectType;
import org.academiadecodigo.tank.gameobjects.GameObjects;
import org.academiadecodigo.tank.gameobjects.ObjectFactory;
import org.academiadecodigo.tank.gameobjects.tank.Enemy;
import org.academiadecodigo.tank.gameobjects.tank.MovableDestroyable;
import org.academiadecodigo.tank.gameobjects.tank.Player;
import org.academiadecodigo.tank.gameobjects.tank.Shell;
import org.academiadecodigo.tank.gfx.simplegfx.SimpleGfxGrid;
import org.academiadecodigo.tank.grid.Grid;
import org.academiadecodigo.tank.utilities.Factory;
import org.academiadecodigo.tank.utilities.InputType;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {


    private Collision collision;
    private ObjectFactory factory;
    private LinkedList<GameObjects> objectsList;
    private Grid grid;
    private GameObjects goal;
    private int maxEnemies = 4;
    private int currentEnemies;
    private GameObjects player;
    private boolean win;


    public Game() {
        init();
    }

    public void init() {

        grid = new SimpleGfxGrid();
        grid.init();
        factory = new ObjectFactory(grid);
        objectsList = new LinkedList<>();
        collision = new Collision(objectsList);

        goal = factory.createObject(GameObjectType.GOAL);
        objectsList.add(goal);
        generateLevel(1);


    }

    private void intro() {


    }

    private void generateLevel(int i) {


        switch (i) {

            case 1:

                createBlocks(goal.getPos().getCol() - 4, goal.getPos().getRow(), goal.getPos().getHeight() + 3, 3, factory, objectsList,1);
                createBlocks(goal.getPos().getCol(), goal.getPos().getRow() + 1 + goal.getPos().getHeight(), 3, goal.getPos().getWidth(), factory, objectsList,1);
                createBlocks(goal.getPos().getCol() + goal.getPos().getWidth(), goal.getPos().getRow(), goal.getPos().getHeight() + 3, 3, factory, objectsList,1);
                createBlocks(0, grid.getRows()/2, 6,20,factory,objectsList,2);
                createBlocks(grid.getCols() - 20, grid.getRows()/2, 6,20, factory,objectsList,2);
                createBlocks(grid.getCols()/2 - 5, grid.getRows()/2 - 13, 26, 10, factory,objectsList,2);

                maxEnemies = 4;

        }

    }


    private void createBlocks(int col, int row, int width, int heigth, Factory factory, LinkedList<GameObjects> linkedList, int howMany) {

        for (int i = row; i < width + row; i += howMany) {

            for (int j = col; j < heigth + col; j += howMany) {
                linkedList.add(factory.createEnvironment(j, i, GameObjectType.BRICK));
            }
        }
    }


    private void createTanks() {

        player = factory.createObject(GameObjectType.PLAYER, InputType.SIMPLEGFX, collision);
        objectsList.add(player);

        for (int i = 0; i < 1; i++) {
            objectsList.add(factory.createObject(GameObjectType.ENEMY, collision));
            currentEnemies++;

        }


    }

    public void start() {

        int counter = 0;

        createTanks();

        while (true) {

            ListIterator<GameObjects> it = objectsList.listIterator();

            try {
                Thread.sleep(50);

                for (int i = 0; i < objectsList.size(); i++) {

                    if (!it.hasNext()) {
                        break;
                    }

                    GameObjects object = it.next();

                    if(currentEnemies < maxEnemies && ((counter++) % 2000 == 0)){
                        it.add(factory.createObject(GameObjectType.ENEMY, collision));
                        currentEnemies++;
                    }

                    if (object instanceof MovableDestroyable) {


                        if (!((MovableDestroyable) object).move() && object instanceof Shell) {
                            object.setDestroyed();
                        }

                        if (object instanceof Player) {
                            Player player = (Player) object;

                            if (player.fire()) {
                                it.add(factory.createShell(player, collision));
                            }
                        }

                        if (object instanceof Enemy) {
                            Enemy enemy = (Enemy) object;

                            if (enemy.fire()) {
                                it.add(factory.createShell(enemy, collision));
                            }

                        }
                        collision.checkHitTarget();
                    }

                    if (object.isDestroyed()) {

                        if(object instanceof Enemy) { currentEnemies--; }
                        object.getPos().hide();


                        try {
                            it.remove();
                        } catch (Exception e) {
                            System.out.println("Exception in remove");
                        }
                    }

                }

                if (win = checkVictory()) {
                    break;
                }

                if (player.isDestroyed()) {
                    break;
                }

            } catch (InterruptedException e) {
                e.getMessage();
            }

        }

        if (!win) {
            System.out.println("Defeat");

        } else {
            System.out.println("Won");

        }


    }


    private boolean checkVictory() {

        return !player.isDestroyed() && collision.reachGoal();

    }


}



