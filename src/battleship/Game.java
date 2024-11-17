package battleship;

import java.io.IOException;

public class Game {
    private final String name;
    private final String[][] field;


    public Game(String name,String[][] field) {
        this.name = name;
        this.field = field;
    }

    public void createBoard(){
        Field field = new Field();
        field.createField(this.field);

        System.out.println(this.name + ", place your ships on the game field");
        field.displayField(this.field);
        System.out.println();

        Ship[] ships = {
                new Ship("Aircraft Carrier", 5),
                new Ship("Battleship", 4),
                new Ship("Submarine", 3),
                new Ship("Cruiser", 3),
                new Ship("Destroyer", 2)
        };

        for (Ship ship : ships) {
            ship.createShip(this.field);
            field.displayField(this.field);
            System.out.println();
        }

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Utils.clearScreen();
    }

    public static void play(String[][] field1,String[][] field2) {
        Field field = new Field();

        String[][] fogOfWar1 = new String[11][11];
        String[][] fogOfWar2 = new String[11][11];
        field.createField(fogOfWar1);
        field.createField(fogOfWar2);
        String[][] copy1 = new String[11][11];
        String[][] copy2 = new String[11][11];
        String[][] verifier1 = new String[11][11];
        String[][] verifier2 = new String[11][11];

        for(int i = 0; i < field1.length; i++) {
            for(int j = 0; j < field1[i].length; j++) {
                copy1[i][j] = field1[i][j];
                verifier1[i][j] = field1[i][j];
                copy2[i][j] = field2[i][j];
                verifier2[i][j] = field2[i][j];
            }
        }

        int turn = 1;
        int shipsRemaining1 = 5;
        int shipsRemaining2 = 5;

        while(true) {
            if(turn == 1) {
                shipsRemaining2 = playerTurn("Player 1", field, field1, fogOfWar2, field2, copy2, verifier2, shipsRemaining2);
                    if(shipsRemaining2 == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    }
                System.out.println("Press Enter and pass the move to another player");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Utils.clearScreen();
                turn = -1;
            }else {
                shipsRemaining1 = playerTurn("Player 2", field, field2, fogOfWar1, field1, copy1, verifier1, shipsRemaining1);
                    if(shipsRemaining1 == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    }
                System.out.println("Press Enter and pass the move to another player");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Utils.clearScreen();
                turn = 1;
            }
        }
    }

    public static int playerTurn(String playerName, Field fieldHelper, String[][] playerField,
                                  String[][] opponentFogOfWar, String[][] opponentField,
                                  String[][] opponentCopy, String[][] opponentVerifier, int shipsRemaining) {
        fieldHelper.displayField(opponentFogOfWar);
        System.out.println("---------------------");
        fieldHelper.displayField(playerField);
        System.out.println(playerName + ", it's your turn:");

        boolean shipSunk = Utils.shoot(opponentField, opponentFogOfWar, opponentCopy, opponentVerifier);
        if (shipSunk) {
            shipsRemaining--;
        }
        return shipsRemaining;
    }
}
