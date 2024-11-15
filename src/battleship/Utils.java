package battleship;

import java.util.Scanner;

public class Utils {

    public static int calculateLength(String first,String second) {
        char firstRow = first.charAt(0);
        char secondRow = second.charAt(0);
        int firstCol = Integer.parseInt(first.substring(1));
        int secondCol = Integer.parseInt(second.substring(1));
        int length = 0;
        String[] parts;
        if(firstRow == secondRow){
            if (firstCol > secondCol) {
                int temp = firstCol;
                firstCol = secondCol;
                secondCol = temp;
            }
            int start = Math.min(firstCol, secondCol);
            int end = Math.max(firstCol, secondCol);
            length = end - start + 1;
            parts = new String[length];
            int j = firstCol;
            for (int i = 0; i < length; i++) {
                parts[i] = first.charAt(0) + String.valueOf(j) + " ";
                j++;
            }
        }else if(firstCol == secondCol){
            if (firstRow > secondRow) {
                char temp = firstRow;
                firstRow = secondRow;
                secondRow = temp;
            }
            char start = (char) Math.min(firstRow, secondRow);
            char end = (char) Math.max(firstRow, secondRow);
            length = end - start + 1;
            parts = new String[length];
            for (int i = 0; i < length; i++) {
                char currentRow = firstRow;
                String currentCol = String.valueOf(firstCol);
                parts[i] =(char)(currentRow + i) + currentCol + " ";
            }
        }
        return length;
    }

    public static boolean collisionCheck(String[][] field, String first, String second) {
        char firstRow = first.charAt(0);
        char secondRow = second.charAt(0);
        int firstCol = Integer.parseInt(first.substring(1));
        int secondCol = Integer.parseInt(second.substring(1));
        boolean collision = true;

        if(firstRow == secondRow){
            if (firstCol > secondCol) {
                int temp = firstCol;
                firstCol = secondCol;
                secondCol = temp;
            }
            for(int i = firstCol; i < secondCol; i++){
                if(((i - 1 != 0) && (firstRow - '@' - 1 != 0)) && ((i + 1 != 11) && (firstRow - '@' + 1 != 11)) && ((firstCol - 1 != 0) && (secondCol + 1 != 11))){
                    if(field[firstRow - '@' - 1][i - 1].equals("O ") ){
                        collision = false;
                        break;
                    }else if(field[firstRow - '@' + 1][i + 1].equals("O ")){
                        collision = false;
                        break;
                    }else if(field[firstRow - '@'][firstCol - 1].equals("O ") && field[firstRow - '@'][secondCol + 1].equals("O ")){
                        collision = false;
                        break;
                    }
                }
            }
        }else if(firstCol == secondCol) {
            if (firstRow > secondRow) {
                char temp = firstRow;
                firstRow = secondRow;
                secondRow = temp;
            }
            for (int i = (firstRow - '@'); i <= (secondRow - '@'); i++) {
                if ((i - 1 != 0 && firstCol - 1 != 0) && (i + 1 != 11 && firstCol + 1 != 11) && (firstRow - '@' - 1 != 0 && firstRow - '@' + 1 != 11)) {
                    if (field[i - 1][firstCol - 1].equals("O ")) {
                        collision = false;
                        break;
                    } else if (field[i + 1][firstCol + 1].equals("O ")) {
                        collision = false;
                        break;
                    }
                } else if (field[firstRow - '@' - 1][firstCol].equals("O ") && field[firstRow - '@' + 1][firstCol].equals("O ")) {
                    collision = false;
                    break;
                }
            }
        }
        return collision;
    }

    public static void shoot(String[][] field1,String[][] field2) {
        Field field = new Field();
        Scanner scanner = new Scanner(System.in);
        field.displayField(field2);

        System.out.println("Take a shot!");

        while(true) {
            String shootingPosition = scanner.nextLine();

            char row = shootingPosition.charAt(0);
            int col = Integer.parseInt(shootingPosition.substring(1));

            if((row >= 'A' && row <= 'J') && (col >= 1 && col <= 10)) {
                if(field1[row - '@'][col].equals("O ")) {
                    field2[row - '@'][col] = "X ";
                    field1[row - '@'][col] = "X ";
                    field.displayField(field2);
                    System.out.println("You hit a ship!");
                    field.displayField(field1);
                    break;
                }else {
                    field1[row - '@'][col] = "M ";
                    field.displayField(field2);
                    System.out.println("You missed!");
                    field.displayField(field1);
                    break;
                }
            }else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
    }
}
