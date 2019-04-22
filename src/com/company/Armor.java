package com.company;

/*
 * 2019 Wyatt Harrison
 */

public class Armor {
    private String name;
    private int defense;

    public Armor(String n, int def) {
        name = n;
        defense = def;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ":\tDef: " + defense;
    }

}
