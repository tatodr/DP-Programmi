import java.util.Scanner;

/**
 * L'algoritmo EditDistance è utilizzato per misurare la similarità tra due stringhe,
 * contando il numero minimo di operazioni di inserimento, eliminazione e sostituzione necessarie per trasformare una stringa nell'altra.
 *
 * Esempio:
 * String1 = "sunday"
 * String2 = "saturday"
 */

public class EditDistanceString {

    static int editDistance(int[][] memo, int dim1, int dim2, String str1, String str2){
        if (dim1 == 0) {
            // Dovrò cancellare tutte le lettere di string2
            return dim2;
        }

        if (dim2 == 0) {
            return dim1;
        }

        if (memo[dim1-1][dim2-1] != 0) {
            return memo[dim1-1][dim2-1];
        }

        if (str1.charAt(dim1-1) == str2.charAt(dim2-1)) {
            return memo[dim1-1][dim2-1] = editDistance(memo, dim1-1, dim2-1, str1, str2);
        } else {
            memo[dim1-1][dim2-1] = 1 + minimo3op(editDistance(memo, dim1-1, dim2, str1, str2),
                    editDistance(memo, dim1, dim2-1, str1, str2), editDistance(memo, dim1-1, dim2-1, str1, str2));
        }

        return memo[dim1-1][dim2-1];
    }

    static int minimo3op(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }
    static void initMemo(int[][] memo, int dim1, int dim2){
        for(int i=0; i<dim1; i++){
            for(int j=0; j<dim2; j++){
                memo[i][j] = 0;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String string1 = "sunday";
        String string2 = "saturday";

        int dim1 = string1.length();
        int dim2 = string2.length();
        int[][] memo = new int[dim1][dim2];

        initMemo(memo, dim1, dim2);
        System.out.println("Numero minimo di operazioni: " + editDistance(memo, dim1, dim2, string1, string2));

    }

}
