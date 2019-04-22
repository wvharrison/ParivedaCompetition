package com.company;

/*
 * 2019 Wyatt Harrison
 */

public class Enemy {
    private String name;
    private int attack;
    private int defense;
    private int hp;

    public Enemy(String n, int att, int def, int h) {
        name = n;
        attack = att;
        defense = def;
        hp = h;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
    }

}
