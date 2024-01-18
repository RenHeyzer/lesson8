package game;

public abstract class GameEntity implements GameEntityLive, CauseAndTakeDamage {

    protected int health;
    protected int damage;
    protected Weapon weapon;

    public GameEntity(int health, int damage, Weapon weapon) {
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void ifDead() {
        if (health < 0) {
            health = 0;
        }
    }

    @Override
    public void causeDamage(GameEntity entity) {
        if (isAlive()) {
            entity.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage(int damage) {
        if (isAlive()) {
            health -= damage;
            ifDead();
        }
    }

    public String getInfo() {
        return "[" + health + "] Damage: [" + damage + "]";
    }
}
