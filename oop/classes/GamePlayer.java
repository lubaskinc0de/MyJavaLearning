package oop.classes;

import oop.enums.PLAYERSTATES;

public class GamePlayer {
    private int x;
    private int y;
    private int health;
    public String name;
    private String[] items;
    private int[] walkingTo;

    private PLAYERSTATES state;

    {
        health = 100;
        x = 0;
        y = 0;
        items = new String[5];
        walkingTo = new int[2];
        state = PLAYERSTATES.STAYING;
    }

    public GamePlayer(String playerName) {
        name = playerName;
    }

    public GamePlayer(String playerName, int[] coords) {
        this(playerName);
        this.setCoords(coords);
    }

    public void walkTo(int x, int y) {
        state = PLAYERSTATES.WALKING;
        walkingTo = new int[]{x, y};
    }

    public void stop() {
        state = PLAYERSTATES.STAYING;

        x = walkingTo[0];
        y = walkingTo[1];

        walkingTo = new int[2];
    }

    public void setCoords(int... coords) {
        this.x = coords[0];
        this.y = coords[1];
    }

    public int[] getCoords() {
        return new int[]{x, y};
    }

    public PLAYERSTATES getState() {
        return state;
    }

}
