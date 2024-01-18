package hero;

import game.GameEntity;
import game.HavingSuperAbility;
import game.Weapon;

import java.util.Random;

public abstract class Hero extends GameEntity implements HavingSuperAbility {

    protected String name;
    protected String superAbility;

    public Hero(int health, int damage, Weapon weapon, String name, String superAbility) {
        super(health, damage, weapon);
        this.name = name;
        this.superAbility = superAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuperAbility() {
        return superAbility;
    }

    public void setSuperAbility(String superAbility) {
        this.superAbility = superAbility;
    }

    public int criticalChance() {
        Random random = new Random();
        return random.nextInt(5);
    }

    @Override
    public void causeDamage(GameEntity entity) {
        if (isAlive() && criticalChance() > 3) {
            Random random = new Random();
            int coefficient = random.nextInt(4) + 2;
            entity.takeDamage(damage * coefficient);
            applySuperAbility(superAbility);
            return;
        }
        super.causeDamage(entity);
    }

    @Override
    public String getInfo() {
        return getName() + " " + super.getInfo();
    }
}
