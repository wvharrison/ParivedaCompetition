package com.company;

/*
 * 2019 Wyatt Harrison
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Welcome to Kwest!");
        PlayerCharacter playerCharacter = characterCreator(keyboard);
        System.out.println();
        playerCharacter.displayCharacter();
        System.out.println();
        System.out.println("Are you happy with this character? (y/n)");
        keyboard.nextLine();
        char userInput = keyboard.nextLine().charAt(0);
        while (userInput == 'n') {
            System.out.println("Okay, you can make a new character.");
            playerCharacter = characterCreator(keyboard);
            System.out.println();
            playerCharacter.displayCharacter();
            System.out.println();
            System.out.println("Are you happy with this character? (y/n)");
            keyboard.nextLine();
            userInput = keyboard.next().charAt(0);
        }

        System.out.println();
        System.out.println("You wake up in the middle of a field you don't recognize. As you stand and collect yourself, an old man approaches you.");
        System.out.println("OLD MAN:\tHello! You must be the new adventurer!");
        System.out.println("You don't know anything about being any sort of adventurer, and tell the old man as much.");
        System.out.println("OLD MAN:\tOf course you're an adventurer! Only adventurers wake up here! Ah, look, perfect!");
        System.out.println("You follow the annoying old man's gaze to see a rabid dog, foaming at the mouth, limping towards you.");
        System.out.println("You let the old man know you find nothing about this perfect.");
        System.out.println("OLD MAN:\tThis is a perfect time to teach you about the ins and outs of combat, as old men in these games do!");
        System.out.println("OLD MAN:\tYou're about to enter combat with this dog. He's probably pretty weak, so don't worry!");
        System.out.println("OLD MAN:\tIn combat, you'll have 3 options: attack, use a potion, or run away.");
        System.out.println("OLD MAN:\tAttacking, of course, will be your main form of victory. Reduce your opponent's HP to 0 to win a battle.");
        System.out.println("OLD MAN:\tUsing a potion will cause you to regain 40% of your own HP. Here, have one!");
        System.out.println("OLD MAN:\tRunning away will give you the opportunity to try the battle again with renewed vigor.");
        System.out.println("Before you can explain that this is really a lot to take in, the dog reaches you and attacks!");

        // "Magic numbers" in enemy and equipment are for balance reasons, and were arrived at after testing various values.
        Enemy dog = new Enemy("Rabid Dog", 2, 3, 80);
        battler(keyboard, playerCharacter, dog);

        System.out.println("OLD MAN:\tYou did it! See how easy that is?");
        System.out.println("You ask the old man what the gold is for.");
        System.out.println("OLD MAN:\tNot quite sure, but it sure is shiny, take it! And look!");
        System.out.println("The old man directs your attention to a bike helmet and a particularly short, dull dagger where the dog once was.");
        System.out.println("As you reach to take them, the old man stops you.");
        System.out.println("OLD MAN:\tChoose Wisely, you can only take one.");
        newEquipChooser(keyboard, playerCharacter, new Armor("Bike Helmet", 3), new Weapon("Short Dagger", 5, 0, 85));

        System.out.println("Sure enough, as soon as you take your prize, the other disappears.");
        System.out.println("You look up to face the old man, but he too, seems to have disappeared.");
        System.out.println("'Probably for the best,' you think, as you wander in a random direction.");
        System.out.println("But you don't get far before hearing the roar of a giant bear, and see a grizzly bear chasing you down.");

        Enemy grizzly = new Enemy("Big Grizzly", 8, 6, 120);
        battler(keyboard, playerCharacter, grizzly);

        System.out.println("Again, you see two new pieces of equipment before you...");
        newEquipChooser(keyboard, playerCharacter, new Armor("Iron Gauntlets", 6), new Weapon("Bashin' Shield", 5, 3, 75));

        System.out.println("You keep wandering to the edge of the field, wondering what the point of this exercise is.");
        System.out.println("Just past the field, you enter a seemingly large, but strangely empty, city.");
        System.out.println("The only people you see are a trio of thuggish people in the distance.");
        System.out.println("As they approach you (somewhat menacingly), you ask them who they are and what's going on.");
        System.out.println("LEAD THUG:\tC'mon, eh? Just a couple of us guys! Just a couple of guys around here! Nothin' weird, nothin' strange, just wanna talk to ya!");
        System.out.println("He doesn't seem that interested in talking, though, as he comes at you with a knife...");

        Enemy thug = new Enemy("Lead Thug", 11, 7, 135);
        battler(keyboard, playerCharacter, thug);

        System.out.println("The other two thugs are clearly rattled.");
        System.out.println("THUG 2:\tWhat are you, some sort of warrior?");
        System.out.println("You ask them again what's going on here.");
        System.out.println("THUG 3:\tThe only people left in the city are the gangs. The dragon drove off the rest...");
        System.out.println("He motions towards a cave in the distance.");
        System.out.println("Before you can ask anything else, the thugs scatter.");
        System.out.println("Again, you see two new pieces of equipment before you...");
        newEquipChooser(keyboard, playerCharacter, new Armor("Steel Helmet", 10), new Weapon("Broadsword", 10, 0, 90));

        System.out.println("You venture cautiously towards the cave outside of the city.");
        System.out.println("As you reach the mouth, you hesitate. Are you sure you're able to slay a dragon?");
        System.out.println("Before you can decide, there's a massive thud behind you.");
        System.out.println("You turn to see a fire-breathing dragon!");

        Enemy dragon = new Enemy("Dragon", 12, 9, 150);
        battler(keyboard, playerCharacter, dragon);
        playerCharacter.incPotions();

        System.out.println("The dragon slain, you pause before heading back to the city.");
        System.out.println("You need to find out how to get back home.");
        System.out.println("But just before you start back, you hear a voice behind you...");
        System.out.println("OLD MAN:\tYou didn't think that was the real dragon, did you?");
        System.out.println("You turn to face the old man from the field as he starts to laugh.");
        System.out.println("OLD MAN:\tNo, no, that was just a baby.");
        System.out.println("Before you can even think, the old man starts to morph into a massive, three-headed dragon.");
        System.out.println("In your panic, you scramble towards the dragonscale armor left by the first dragon.");
        System.out.println("To your surprise, the golden sword it also left behind remains, and you take it up, too.");
        System.out.println("You turn to face the dragon.");

        playerCharacter.setArmor(new Armor("Dragonscale Armor", 60));
        playerCharacter.setWeapon(new Weapon("Golden Sword", 50, 0, 95));
        Enemy trueDragon = new Enemy("Dragon of Legend", 40, 40, 200);
        battler(keyboard, playerCharacter, trueDragon);

        System.out.println("You bolt upright in bed.");
        System.out.println("Was it all just a dream?");
        System.out.println("As you rub the sleep out of your eyes, you wonder. It felt so real.");
        System.out.println("But it can't have been. Dragons don't exist.");
        System.out.println("But as you turn and face the corner of your room, you see a golden sword propped against the wall...");
        System.out.println("---THE END---");
        keyboard.nextLine();
    }

    // Character creation system, returns the created character.
    private static PlayerCharacter characterCreator(Scanner keyboard) {
        int allocatedPoints = 0;

        System.out.println("What is your character's name?");
        String name = keyboard.nextLine();

        System.out.println("Now you'll get a chance to allocate stat points for " + name + ".");
        System.out.println("You'll have 40 points to allocate. You need to put at least one point and no more than 20 into each attribute.");
        System.out.println("The attributes are as follows:");
        System.out.println("\tStrength: This attribute measures your character's physical strength.");
        System.out.println("\t  A character with high strength will have stronger attacks and slightly more defense in battle.");
        System.out.println("\tDexterity: This attribute measures how precise and skillful your character is.");
        System.out.println("\t  A character with high dexterity will have better accuracy and evasion in battle.");
        System.out.println("\tIntelligence: This attribute measures how quick-thinking your character is.");
        System.out.println("\t  A character with high intelligence will have an easier time landing and avoiding critical hits in battle.");
        System.out.println("\tHealth: This attribute measures how much damage your character can take without being defeated.");
        System.out.println("\t  A character with high health will have higher HP and slightly more defense in battle.");

        System.out.println("How much strength would you like your character to have?");
        int strength = keyboard.nextInt();
        while (strength < 1 || strength > 20) {
            System.out.println("Please enter a value between 0 and 20.");
            strength = keyboard.nextInt();
        }
        allocatedPoints += strength;

        System.out.println("How much dexterity would you like your character to have?");
        int dexterity = keyboard.nextInt();
        while (dexterity < 1 || dexterity > 20 || allocatedPoints + dexterity > 38) {
            System.out.println("Please enter a value between 0 and 20 and make sure you haven't allocated more than 38 points yet.");
            dexterity = keyboard.nextInt();
        }
        allocatedPoints += dexterity;

        System.out.println("How much intelligence would you like your character to have?");
        int intelligence = keyboard.nextInt();
        while (intelligence < 1 || intelligence > 20 || allocatedPoints + intelligence > 39) {
            System.out.println("Please enter a value between 0 and 20 and make sure you haven't allocated more than 39 points yet.");
            intelligence = keyboard.nextInt();
        }
        allocatedPoints += intelligence;

        System.out.println("How much health would you like your character to have?");
        int health = keyboard.nextInt();
        while (health < 1 || health > 20 || allocatedPoints + health > 40) {
            System.out.println("Please enter a value between 0 and 20 and make sure you haven't allocated more than 40 points yet.");
            health = keyboard.nextInt();
        }
        allocatedPoints += health;

        return new PlayerCharacter(name, strength, dexterity, intelligence, health);
    }

    // Handles new equipment after each battle. One armor option and one weapon option after each battle.
    public static void newEquipChooser(Scanner keyboard, PlayerCharacter playerCharacter, Armor armor, Weapon weapon) {
        playerCharacter.incPotions();
        System.out.println();
        System.out.println("---YOUR EQUIPMENT---");
        System.out.println("Armor:\t" + playerCharacter.getArmor());
        System.out.println("Weapon:\t" + playerCharacter.getWeapon());
        System.out.println();
        System.out.println("---AVAILABLE EQUIPMENT---");
        System.out.println("Armor:\t" + armor);
        System.out.println("Weapon:\t" + weapon);
        System.out.println();

        System.out.print("Choose one and choose wisely: 'a' for armor, or 'w' for weapon: ");
        char selection = keyboard.nextLine().toLowerCase().charAt(0);
        while(selection != 'a' && selection != 'w') {
            System.out.print("Please select 'a' for the armor or 'w' for the weapon: ");
            selection = keyboard.nextLine().toLowerCase().charAt(0);
        }

        if(selection == 'a') {
            System.out.println("You selected the " + armor.getName() + "!");
            playerCharacter.setArmor(armor);
        }
        else {
            System.out.println("You selected the " + weapon.getName() + "!");
            playerCharacter.setWeapon(weapon);
        }
        System.out.println();
    }

    // Easily connects Main class to Battle class. Players are left in a loop until they win.
    // (Unfortunately, this could potentially lead to grinding for crits if a player allocated stats in such
    // a way that battles become unreasonably difficult).
    public static void battler(Scanner keyboard, PlayerCharacter playerCharacter, Enemy enemy) {
        System.out.println();
        int result = 1;
        while(result == 1) {
            Battle battle = new Battle(playerCharacter, enemy);
            result = battle.battleController(keyboard);
            if(result == 1) {
                System.out.println("You feel defeated for now, but you gather your strength to face your foe again...");
            }
        }
    }

}
