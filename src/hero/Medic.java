package hero;

import game.Weapon;

import java.util.Random;

public class Medic extends Hero {

    public Medic(int health, int damage, Weapon weapon, String name, String superAbility) {
        super(health, damage, weapon, name, superAbility);
    }

    @Override
    public void applySuperAbility(String superAbilityType) {
        System.out.println(name + " использовал суперспособность: " + superAbilityType);
    }

    public void heal(int healPoints, Hero hero) {
        if (isAlive() && hero.isAlive()) {
            int points;
            if (criticalChance() > 3) {
                Random random = new Random();
                int coefficient = random.nextInt(4) + 2;
                points = healPoints * coefficient;
                applySuperAbility(superAbility);
            } else {
                points = healPoints;
            }
            int curedHeroHealth = hero.getHealth() + points;
            hero.setHealth(curedHeroHealth);
            System.out.println(name + " вылечила " + hero.getName() + " на " + points);
        }
    }
}
