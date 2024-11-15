package battleship;

public class Field {

    public void createField(String[][] field) {
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
    }

    public void displayField(String[][] field){
        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public void modifyField(String[][] field, String first, String second){
        char firstRow = first.charAt(0);
        char secondRow = second.charAt(0);
        int firstCol = Integer.parseInt(first.substring(1));
        int secondCol = Integer.parseInt(second.substring(1));

        if(firstRow == secondRow){
            if (firstCol > secondCol) {
                int temp = firstCol;
                firstCol = secondCol;
                secondCol = temp;
            }
            for(int j = firstCol; j <= secondCol; j++){
                field[firstRow - '@'][j] = "O ";
            }
        }else if(firstCol == secondCol){
            if (firstRow > secondRow) {
                char temp = firstRow;
                firstRow = secondRow;
                secondRow = temp;
            }
            for(int j = (firstRow - '@'); j <= (secondRow - '@'); j++){
                field[j][firstCol] = "O ";
            }
        }
    }
}
