package game;

public enum Weapon {
    BOW("Лук"),
    STAFF("Посох"),
    AID_KIT("Аптечка"),
    SWORD("Меч"),
    MORGENSTERN("Моргенштерн");

    private String weaponName;

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWeaponName() {
        return weaponName;
    }

    Weapon(String weaponName) {
        this.weaponName = weaponName;
    }
}