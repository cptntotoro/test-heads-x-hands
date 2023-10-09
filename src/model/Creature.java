package model;

public abstract class Creature {
    private final CreatureType type;
    private final int attack;
    private final int defence;
    private int health;
    private final int maxHealth;
    private boolean isAlive = true;

    public Creature(CreatureType type, int attack, int defence, int health) {
        if (attack >= 1 && attack <= 30) {
            this.attack = attack;
        } else {
            throw new RuntimeException("Параметр 'Атака' должен быть в диапазоне от 1 до 30");
        }

        if (defence >= 1 && defence <= 30) {
            this.defence = defence;
        } else {
            throw new RuntimeException("Параметр 'Защита' должен быть в диапазоне от 1 до 30");
        }

        if (health > 0) {
            this.health = health;
            this.maxHealth = health;
        } else {
            throw new RuntimeException("Параметр 'Здоровье' должен быть больше нуля");
        }

        this.type = type;
    }

    public CreatureType getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDefence() {
        return defence;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "model.Creature{" +
                "type=" + type +
                ", attack=" + attack +
                ", defence=" + defence +
                ", maxHealth=" + maxHealth +
                '}';
    }
}
