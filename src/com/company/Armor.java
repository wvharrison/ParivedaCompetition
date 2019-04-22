package com.company;

public class Armor {
    String name;
    int defense;

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
