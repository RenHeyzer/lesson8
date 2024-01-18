package boss;

import game.GameEntity;
import game.Weapon;

public class Boss extends GameEntity {

    private String immunityType;

    public Boss(int health, int damage, Weapon weaponType, String immunityType) {
        super(health, damage, weaponType);
        this.immunityType = immunityType;
    }

    public void setImmunityType(String immunityType) {
        this.immunityType = immunityType;
    }

    public String getImmunityType() {
        return immunityType;
    }

    @Override
    public String getInfo() {
        return "Boss " + super.getInfo();
    }
}