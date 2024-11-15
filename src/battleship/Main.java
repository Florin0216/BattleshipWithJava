package battleship;

public class Main {

    public static void main(String[] args) {

        String[][] field = new String[11][11];
        Field gameField = new Field();

        gameField.createField(field);
        gameField.displayField(field);

        Ship aircraftCarrier = new Ship("Aircraft Carrier",5);
        aircraftCarrier.createShip(field);
        gameField.displayField(field);

        Ship battleship = new Ship("Battleship",4);
        battleship.createShip(field);
        gameField.displayField(field);

        Ship submarine = new Ship("Submarine",3);
        submarine.createShip(field);
        gameField.displayField(field);

        Ship cruiser = new Ship("Cruiser",3);
        cruiser.createShip(field);
        gameField.displayField(field);

        Ship destroyer = new Ship("Destroyer",2);
        destroyer.createShip(field);
        gameField.displayField(field);
    }
}
