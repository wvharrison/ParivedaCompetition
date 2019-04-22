package com.company;

/*
 * 2019 Wyatt Harrison
 */

public class Weapon {
    private String name;
    private int attack;
    private int defense;
    private int accuracy;

    public Weapon(String n, int att, int d, int acc) {
        name = n;
        attack = att;
        defense = d;
        accuracy = acc;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ":\tAtt: " + attack + "\tDef: " + defense + "\tAcc: " + accuracy;
    }
}
