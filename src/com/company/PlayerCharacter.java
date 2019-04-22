package com.company;

public class PlayerCharacter {
    String name;
    int strength;
    int dexterity;
    int intelligence;
    int health;
    Armor armor;
    Weapon weapon;
    int gold;
    int potions;

    public PlayerCharacter(String n, int st, int dx, int iq, int ht) {
        name = n;
        // Attributes range 1-20; player gets 40 to allocate.
        strength = st;
        dexterity = dx;
        intelligence = iq;
        health = ht;
        armor = new Armor("T-shirt", 0);
        weapon = new Weapon("Fists", 1, 0, 90);
        gold = 100;
        potions = 1;
    }

    public void displayCharacter() {
        System.out.println(name);
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Health: " + health);
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() {
        return health;
    }

    public Armor getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getGold() {
        return gold;
    }

    public int getPotions() {
        return potions;
    }

    public int removeGold(int amt) {
        gold -= amt;
        return gold;
    }

    public int addGold(int amt) {
        gold += amt;
        return gold;
    }

    public int getBaseHP() {
        return health * 10;
    }

    public int usePotion() {
        potions--;
        return potions;
    }

    public void setWeapon(Weapon w) {
        weapon = w;
    }

    public void setArmor(Armor a) {
        armor = a;
    }

    public void incPotions() {
        potions++;
    }

}
