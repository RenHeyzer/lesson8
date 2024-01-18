package hero;

import game.Weapon;

public class Warrior extends Hero {

    public Warrior(int health, int damage, Weapon weapon, String name, String superAbility) {
        super(health, damage, weapon, name, superAbility);
    }

    @Override
    public void applySuperAbility(String superAbilityType) {
        System.out.println(name + " использовал суперспособность: " + superAbilityType);
    }
}