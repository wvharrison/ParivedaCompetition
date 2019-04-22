package com.company;

import java.util.Scanner;

public class Battle {
    // NOTE: A lot of the "magic numbers" in this class's methods are for balance in battles.
    PlayerCharacter player;
    int playerHP;
    Enemy enemy;
    int enemyHP;

    public Battle(PlayerCharacter pc, Enemy e) {
        player = pc;
        playerHP = pc.getBaseHP();
        enemy = e;
        enemyHP = e.getHp();
    }

    // Returns are following:
    // 1: Enemy defeats player
    // 0: Player defeats Enemy
    public int battleController(Scanner keyboard) {
        boolean charged = false;
        while(enemyHP > 0 && playerHP > 0) {
            int playerTurnResult = playerTurn(keyboard);
            if(playerTurnResult == 1) return 0;
            else if(playerTurnResult == -1) return 1;
            int enemyTurnResult = enemyTurn(keyboard, charged);
            if(charged) charged = false; // Set charge back to false after the charged attack was used.
            if(enemyTurnResult == 1) return 1;
            if(enemyTurnResult == 2) charged = true;
        }
        return 0;
    }

    // Returns are following:
    // 0: Battle continues
    // 1: Player defeats enemy
    // -1: Player successfully runs away
    private int playerTurn(Scanner keyboard) {
        System.out.println("What will " + player.getName() + " do?");
        System.out.println(player.getName() + ": " + playerHP + "/" + player.getBaseHP());
        System.out.println(enemy.getName() + ": " + enemyHP + "/" + enemy.getHp());
        System.out.println("\t1. Attack");
        System.out.println("\t2. Use Potion (" + player.getPotions() + " left)");
        System.out.println("\t3. Run Away");
        switch (keyboard.next().charAt(0)) {
            case '1':
                playerAttack();
                if(enemyHP <= 0) {
                    System.out.println(player.getName() + " defeated " + enemy.getName() + "!");
                    System.out.println(player.getName() + " got " + (enemy.getAttack() + enemy.getDefense()) * 10 + " gold and a potion!");
                    player.addGold((enemy.getAttack() + enemy.getDefense()) * 10);
                    System.out.println("Press ENTER to continue.");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    return 1;
                }
                break;
            case '2':
                usePotion();
                break;
            case '3':
                if(runAway()) {
                    System.out.println("Got away safely!");
                    System.out.println("Press ENTER to continue.");
                    keyboard.nextLine();
                    keyboard.nextLine();
                    return -1;
                }
                else {
                    System.out.println(player.getName() + " tried to run away, but couldn't!");
                }
                break;
            default:
                System.out.println("You selected an invalid value. " + player.getName() + " flailed around uselessly.");
        }
        System.out.println("Press ENTER to continue.");
        keyboard.nextLine();
        keyboard.nextLine();
        return 0;
    }

    private void playerAttack() {
        int playerAtt = player.getStrength() + player.getWeapon().getAttack();
        int enemyDef = enemy.getDefense();
        int damage = (playerAtt - enemyDef) + (playerAtt - enemyDef) / 2;
        if(damage < 3) damage = 3;
        if(playerAttackHits()) {
            if(isPlayerCriticalHit()) {
                damage *= 2;
                System.out.println("A critical hit!");
            }
            System.out.println(player.getName() + " did " + damage + " damage!");
            enemyHP -= damage;
        }
        else {
            System.out.println(player.getName() + "'s attack misses!");
        }
    }

    private boolean playerAttackHits() {
        double accuracy = (double)(player.getDexterity() + player.getWeapon().getAccuracy()) / 100;
        if(Math.random() < accuracy) return true;
        else return false;
    }

    private boolean isPlayerCriticalHit() {
        double critChance = (double)player.getIntelligence() / 100;
        if(Math.random() < critChance) return true;
        else return false;
    }

    private void usePotion() {
        if(player.getPotions() < 1) {
            System.out.println(player.getName() + " reaches for a potion, but nothing's there...");
            return;
        }
        int initHP = playerHP;
        int recovery = (4 * player.getBaseHP()) / 10;
        player.usePotion();
        playerHP += recovery;
        if(playerHP > player.getBaseHP()) playerHP = player.getBaseHP();
        System.out.println(player.getName() + " drank a potion and recovered " + (playerHP - initHP) + " HP!");
    }

    private boolean runAway() {
        double runChance = 0.033 * player.getDexterity();
        if(Math.random() < runChance) return true;
        else return false;
    }

    // Returns are following:
    // 0: Battle continues
    // 1: Ememy defeats player
    // 2: Enemy charges up
    private int enemyTurn(Scanner keyboard, boolean charged) {

        if(Math.random() < 0.1 && !charged) {
            System.out.println(enemy.getName() + " started charging up...");
            System.out.println("Press ENTER to continue.");
            keyboard.nextLine();
            return 2;
        }

        else {
            enemyAttack(charged);
            System.out.println("Press ENTER to continue.");
            keyboard.nextLine();
            if(playerHP <= 0) {
                System.out.println(enemy.getName() + " defeated " + player.getName() + "...");
                System.out.println("Press ENTER to continue.");
                keyboard.nextLine();
                return 1;
            }
        }

        return 0;
    }

    private void enemyAttack(boolean charged) {
        System.out.println(enemy.getName() + " attacks!");
        int enemyAtt = enemy.getAttack() * 2;
        int playerDef = ((player.getStrength() + player.getHealth()) / 2) + player.getArmor().getDefense() + player.getWeapon().getDefense();
        int damage = (enemyAtt - playerDef) + (enemyAtt - playerDef) / 2;
        if(damage < 3) damage = 3;
        if(charged) damage *= 3;
        if(enemyAttackHits()) {
            if(isEnemyCriticalHit()) {
                damage *= 2;
                System.out.println("A critical hit!");
            }
            System.out.println(enemy.getName() + " did " + damage + " damage!");
            playerHP -= damage;
        }
        else {
            System.out.println(enemy.getName() + "'s attack misses!");
        }
    }

    private boolean enemyAttackHits() {
        double evasion = player.getDexterity() / 100;
        if(Math.random() < evasion) return false;
        else return true;
    }

    private boolean isEnemyCriticalHit() {
        double dodgeCritChance = 0.8 + (double)player.getIntelligence() / 100;
        if(Math.random() > dodgeCritChance) return true;
        else return false;
    }

}
