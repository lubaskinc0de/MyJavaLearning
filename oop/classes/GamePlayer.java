package oop.classes;

import oop.enums.PlayerStates;

public class GamePlayer {
    private int x;
    private int y;
    private int health;
    public String name;
    private String[] items;
    private int[] walkingTo;

    private PlayerStates state;

    {
        health = 100;
        x = 0;
        y = 0;
        items = new String[5];
        walkingTo = new int[2];
        state = PlayerStates.STAYING;
    }

    public GamePlayer(String playerName) {
        name = playerName;
    }

    public GamePlayer(String playerName, int[] coords) {
        this(playerName);
        this.setCoords(coords);
    }

    public void walkTo(int x, int y) {
        state = PlayerStates.WALKING;
        walkingTo = new int[]{x, y};
    }

    public void stop() {
        state = PlayerStates.STAYING;

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

    public PlayerStates getState() {
        return state;
    }

}
