package model;

public class Player extends Creature {

    private int timesHealed = 0;

    public Player(Integer attack, Integer defence, Integer health) {
        super(CreatureType.PLAYER, attack, defence, health);
    }

    public void heal() {
        if (timesHealed < 4) {
            int healPoints = (int) (this.getMaxHealth() * 0.3);
            int newHealthPoints = this.getHealth() + healPoints;

            this.setHealth(Math.min(newHealthPoints, this.getMaxHealth()));

            timesHealed++;

            System.out.println("Вы восстановили " + healPoints + " очков здоровья.");
            System.out.println("Теперь у вас " + this.getHealth() + " очков здоровья.");
            System.out.println();
        } else {
            System.out.println("Вы израсходовали все 4 возможности восстановить здоровье.");
            System.out.println();
        }
    }
}
