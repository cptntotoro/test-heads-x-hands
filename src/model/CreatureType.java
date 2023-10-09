package model;

import java.util.List;
import java.util.Random;

public enum CreatureType {
    PLAYER("Игрок"),
    GOBLIN("Гоблин"),
    WEREWOLF("Оборотень"),
    CENTAUR("Кентавр"),
    DRAGON("Дракон"),
    WITCH("Ведьма");

    private final String name;

    CreatureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final List<CreatureType> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static CreatureType getRandomMonsterName()  {
        return VALUES.get(RANDOM.nextInt(1, SIZE));
    }
}
