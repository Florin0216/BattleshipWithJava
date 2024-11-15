package battleship;

import java.util.Scanner;

public class Ship {
    final private String name;
    final private int size;

    public Ship(String shipName,int shipSize) {
        this.name = shipName;
        this.size = shipSize;
    }

    public void createShip(String[][] field) {
        Scanner scanner = new Scanner(System.in);
        Field field1 = new Field();
        System.out.println("Enter the coordinates of the " + this.name + " (" + this.size + " cells):");
        while (true) {
            String firstCoordinate = scanner.next();
            String secondCoordinate = scanner.next();

            int length = Utils.calculateLength(firstCoordinate, secondCoordinate);

            boolean validCoordinates = Utils.collisionCheck(field, firstCoordinate, secondCoordinate);

            if ((firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) && (!firstCoordinate.substring(1).equals(secondCoordinate.substring(1)))) {
                System.out.println("Error! Wrong ship location! Try again:");
            } else if(!validCoordinates) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            }else if(length != this.size ) {
                System.out.println("Error! Wrong length of the " + this.name + "! Try again:");
            }else{
                field1.modifyField(field, firstCoordinate, secondCoordinate);
                break;
            }
        }
    }
}
