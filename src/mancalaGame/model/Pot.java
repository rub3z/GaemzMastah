package mancalaGame.model;


import java.util.ArrayList;

public class Pot {

    private ArrayList<Integer> pot;

    public Pot() {
        pot = new ArrayList<>();
    }

    public int size() {
        return pot.size();
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public void add(Integer marble) {
        pot.add(marble);
    }

    public Integer remove() {
        return pot.remove(0);
    }

    public ArrayList<Integer> getPot() {
        return pot;
    }
}
