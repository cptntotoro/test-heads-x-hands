public class Main {
    public static void main(String[] args) {

        System.out.println("---------Игра начинается!---------");
        System.out.println();

        Game game = new Game(4);
        game.automaticPlayGame();
    }
}
