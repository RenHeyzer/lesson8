import boss.Boss;
import game.Weapon;
import hero.Hero;
import hero.Medic;
import hero.Warrior;
import hero.Wizard;

import java.util.Random;

public class Main {

    public static Boss boss;
    public static Hero[] heroes;

    public static void main(String[] args) {
        boss = new Boss(900, 90, Weapon.MORGENSTERN, "");
        heroes = createHeroes();
        start();
    }

    public static Hero[] createHeroes() {
        Hero warrior = new Warrior(330, 50, Weapon.SWORD, "Лютик", "Огненный клинок");
        Hero wizard = new Wizard(290, 70, Weapon.STAFF, "Геральд", "Заморозка");
        Hero medic = new Medic(250, 0, Weapon.AID_KIT, "Ариель", "Критеческое лечение");
        return new Hero[]{warrior, wizard, medic};
    }

    private static void start() {
        int round = 0;
        printStatistics(round);
        while (!isGameFinished()) {
            round++;
            round();
            printStatistics(round);
        }
    }

    public static void round() {
        changeBossImmunityType();
        heroesHit();
        bossHit();
    }

    private static void changeBossImmunityType() {
        Random random = new Random();
        int randomIndex = random.nextInt(3);
        Hero hero = heroes[randomIndex];
        boss.setImmunityType(hero.getName());
    }

    public static void printStatistics(int round) {
        System.out.println("_________________________________________");
        System.out.println("--------------- + Round " + round + " + ---------------");
        System.out.println(boss.getInfo());

        for (Hero hero : heroes) {
            System.out.println(hero.getInfo());
        }

        System.out.println("_________________________________________");
    }

    public static boolean isGameFinished() {
        if (boss.isDead()) {
            System.out.println("<< Heroes won !!! >>");
            return true;
        }

        boolean allHeroesDead = false;

        for (Hero hero : heroes) {
            if (hero.isDead()) {
                allHeroesDead = true;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("<< Boss won !!! >>");
        }
        return allHeroesDead;
    }

    private static void heroesHit() {
        for (Hero hero : heroes) {
            if (boss.getImmunityType() != hero.getName()) {
                if (hero.getName() != "Ариель") {
                    hero.causeDamage(boss);
                } else {
                    Medic medic = (Medic) hero;
                    Random random = new Random();
                    int randomIndex = random.nextInt(3);
                    Hero notMedicHero = heroes[randomIndex];
                    if (notMedicHero.getName() != medic.getName()) {
                        medic.heal(30, notMedicHero);
                    }
                }
            }
        }
    }

    private static void bossHit() {
        for (Hero hero : heroes) {
            boss.causeDamage(hero);
        }
    }
}