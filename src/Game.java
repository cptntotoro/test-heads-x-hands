import model.Creature;
import model.CreatureType;
import model.Monster;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private Player player;

    private List<Monster> monsters;

    private Random random = new Random();

    public Game(int monstersCount) {
        this.player = createRandomPlayer();
        this.monsters = new ArrayList<>();
        for (int i = 0; i < monstersCount; i++) {
            this.monsters.add(createRandomMonster());
        }
    }

    private Player createRandomPlayer() {
        Player player = new Player(random.nextInt(1, 30), random.nextInt(1, 30), random.nextInt(1, 30));
        System.out.println("Сгенерирован игрок: " + player);
        System.out.println();
        return player;
    }

    private Monster createRandomMonster() {
        Monster monster = new Monster(CreatureType.getRandomMonsterName(), random.nextInt(1, 30),
                random.nextInt(1, 30), random.nextInt(1, 30));
        System.out.println("Сгенерирован монстр: " + monster);
        System.out.println();
        return monster;
    }

    public void automaticPlayGame() {
        boolean playerTurn = true;
        while (player.isAlive() && monsters.stream().anyMatch(Creature::isAlive)) {

            if (playerTurn && player.getHealth() < player.getMaxHealth() / 2) {
                player.heal();
            }

            Monster monster = monsters.stream().filter(Creature::isAlive).findFirst().get();

            Creature attackCreature = playerTurn ? player : monster;
            Creature defenceCreature = !playerTurn ? player : monster;

            fight(attackCreature, defenceCreature);

            playerTurn = !playerTurn;
        }

        System.out.println("Игра закончена!");

        if (player.isAlive()) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Потрачено!");
        }
    }

    public void fight(Creature attackCreature, Creature defenceCreature) {
        int attackMod = Math.max(1, attackCreature.getAttack() - defenceCreature.getDefence() + 1);

        if (isAttackSuccessful(attackMod)) {
            int damage = attackCreature.getAttack() > 1 ? random.nextInt(1, attackCreature.getAttack()) : 1;
            int newHealthValue = defenceCreature.getHealth() - damage;

            if (newHealthValue <= 0) {
                System.out.println(defenceCreature.getType().getName()  + " мертв");
                System.out.println();
                defenceCreature.setAlive(false);
                return;
            }

            defenceCreature.setHealth(newHealthValue);
            System.out.println(defenceCreature.getType().getName() + " получает урон = " + damage);
            System.out.println("Текущее здоровье " + defenceCreature.getType().getName() + " = " + newHealthValue);
            System.out.println();
        } else {
            System.out.println("Неудачная атака.");
            System.out.println();
        }
    }

    private boolean isAttackSuccessful(int attackMod) {

        System.out.println("Бросаем кубики: ");

        for (int i = 0; i < attackMod; i++) {
            int dice = random.nextInt(1, 7);
            System.out.println("Значение кубика = " + dice);
            if (dice >= 5) {
                return true;
            }
        }
        return false;
    }
}
