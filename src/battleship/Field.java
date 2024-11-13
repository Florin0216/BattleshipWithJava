package battleship;

public class Field {
    public static void displayField(String[][] field){

        for(int i = 0; i < field.length; i++ ){
            if(i == 0){
                field[0][0] = "  ";
            }else {
                field[0][i] = i + " " ;
                field[i][0] = (char) ('A' + (i - 1)) + " ";
            }
        }

        for(int i = 1; i < field.length; i++){
            for(int j = 1; j < field[i].length; j++){
                field[i][j] = "~ ";
            }
        }
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void getLengthAndParts(String first,String second) {
        char firstRow = first.charAt(0);
        char secondRow = second.charAt(0);
        int firstCol = Integer.parseInt(first.substring(1));;
        int secondCol = Integer.parseInt(second.substring(1));

        boolean ok = true;

        if(firstRow == secondRow){
            if (firstCol > secondCol) {
                int temp = firstCol;
                firstCol = secondCol;
                secondCol = temp;
                ok = false;
            }

            int start = Math.min(firstCol, secondCol);
            int end = Math.max(firstCol, secondCol);
            int length = end - start + 1;

            String[] parts = new String[length];
            int j = firstCol;
            for (int i = 0; i < length; i++) {
                parts[i] = first.charAt(0) + String.valueOf(j) + " ";
                j++;
            }

            System.out.println("Length: " + length);
            System.out.print("Parts: ");
            if (ok) {
                for (int i = 0; i < parts.length; i++) {
                    System.out.print(parts[i] + " ");
                }
            } else {
                for (int i = parts.length - 1; i >= 0; i--) {
                    System.out.print(parts[i] + " ");
                }
            }
        }else if(firstCol == secondCol){
            if (firstRow > secondRow) {
                char temp = firstRow;
                firstRow = secondRow;
                secondRow = temp;
                ok = false;
            }

            char start = (char) Math.min(firstRow, secondRow);
            char end = (char) Math.max(firstRow, secondRow);
            int length = end - start + 1;

            String[] parts = new String[length];
            for (int i = 0; i < length; i++) {
                char currentRow = firstRow;
                String currentCol = String.valueOf(firstCol);
                parts[i] =(char)(currentRow + i) + currentCol + " ";
            }

            System.out.println("Length: " + length);
            System.out.print("Parts: ");
            if (ok) {
                for (int i = 0; i < parts.length; i++) {
                    System.out.print(parts[i] + " ");
                }
            } else {
                for (int i = parts.length - 1; i >= 0; i--) {
                    System.out.print(parts[i] + " ");
                }
            }
        }
    }
}
