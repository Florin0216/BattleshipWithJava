package battleship;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] field = new String[11][11];
        Field gameField = new Field();
        gameField.displayField(field);

        System.out.println("Enter the coordinates of the ship:");
        String firstCoordinate = scanner.next();
        String secondCoordinate = scanner.next();

        int firstIndex = Integer.parseInt(firstCoordinate.substring(1));;
        int secondIndex= Integer.parseInt(secondCoordinate.substring(1));

        if((firstCoordinate.charAt(0) != secondCoordinate.charAt(0)) && (!firstCoordinate.substring(1).equals(secondCoordinate.substring(1)))) {
            System.out.println("Error");
        }else if((firstCoordinate.charAt(0) <'A' || firstCoordinate.charAt(0) >'J')){
            System.out.println("Error");
        }else if((secondCoordinate.charAt(0) <'A' || secondCoordinate.charAt(0) >'J')){
            System.out.println("Error");
        }else if((firstIndex < 1 || firstIndex > 10)){
            System.out.println("Error");
        } else if ((secondIndex < 1 || secondIndex > 10)) {
            System.out.println("Error");
        }else {
            gameField.getLengthAndParts(firstCoordinate, secondCoordinate);
        }
    }
}
