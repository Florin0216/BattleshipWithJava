package battleship;

public class Main {

    public static void main(String[] args) {

        String[][] field1 = new String[11][11];
        String[][] field2 = new String[11][11];

        Game player1 = new Game("Player 1",field1);
        Game player2 = new Game("Player 2",field2);

        player1.createBoard();
        player2.createBoard();

        Game.play(field1,field2);
    }
}
