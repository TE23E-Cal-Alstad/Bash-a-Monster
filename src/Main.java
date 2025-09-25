import java.util.Random;

public class Main {

    static Random randomGenerator = new Random();

    public static void main(String[] args) {

        //gives each character their stats
        Hero myHero = new Hero();
        myHero.name = "Athena";
        myHero.health = 100;
        myHero.level = (randomGenerator.nextInt(2, 10));
        myHero.damage = (randomGenerator.nextInt(25, 100));

        Monster0 myMonster = new Monster0();
        myMonster.name = "Ares";
        myMonster.health = 100;
        myMonster.level = (randomGenerator.nextInt(2, 10));
        myMonster.damage = (randomGenerator.nextInt(25, 100));

        //writes out the health and the level of each character
        System.out.println(myHero.name + " has " + myHero.health + " health and a level of " + myHero.level);
        System.out.println(myMonster.name + " has " + myMonster.health + " health and a level of " + myMonster.level);

        //EXPLAINS HOW DAMAGE WORKS
        System.out.println("\nThe attack damage is based on the other player's level.");
        System.out.println("Random dmg 1-100 divided by other player's level\n");


        // Athena attackerar Ares
        System.out.println(myHero.name + " attacks " + myMonster.name + "!");
        System.out.println(myHero.damage + " Basedamage");
        myMonster.health = standardAttack(myHero.damage, myMonster.health, myMonster.level);
        System.out.println(myMonster.name + " now has " + myMonster.health + " health left.");

        System.out.println(" ");

        //write out new health
        System.out.println(myHero.name + " now has " + myHero.health + " health");
        System.out.println(myMonster.name + " now has " + myMonster.health + " health");
    }

    public static int standardAttack(int damage, int health, int level) {
        double actualDamage = (double) damage / level;
        int damageDone = (int) Math.ceil(actualDamage); // avrunda uppåt så att minst 1 tas
        System.out.println("Damage dealt: " + damageDone);
        health -= damageDone;
        return Math.max(health, 0);
    }

}


