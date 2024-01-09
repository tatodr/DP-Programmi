import java.util.Scanner;

/**
 * La funzione LCS restituisce la lunghezza della sequenza più lunga comune tra due stringhe X e Y
 *
 * Esempio:
 * X="AGGTAB"
 * Y="GXTXAYB"
 * la sequenza più lunga è "GTAB"
 * quindi restituisce "Lunghezza della LCS: 3"
 *
 * COMPLESSITÀ: O(dimX*dimY)
 */

public class LCS {

    public static int lcs(int[][] memo, char[] X, char[] Y, int dimX, int dimY){
        if(dimX == 0 || dimY == 0){
            return 0;
        }

        if(memo[dimX][dimY] != 0){
            return memo[dimX][dimY];
        }

        if(X[dimX-1] == Y[dimY-1]){
            return memo[dimX][dimY] = 1 + lcs(memo, X, Y, dimX-1, dimY-1);
        }

        return memo[dimX][dimY] = Math.max(lcs(memo, X, Y, dimX, dimY-1), lcs(memo, X, Y, dimX-1, dimY));
    }

    static void printMemo(int[][] memo, int dimX, int dimY) {
        for (int i = 0; i < dimX; i++) {
            for (int j = 0; j < dimY; j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initMemo(int[][] memo, int dimX, int dimY){

        for(int i=0; i<dimX; i++){
            for(int j=0; j<dimY; j++){
                memo[i][j] = 0;
            }
        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int dimX = 0;
        int dimY = 0;
        int dimLcs = 0;

        char[] X = "AGGTAB".toCharArray();
        char[] Y = "GXTXAYB".toCharArray();

        System.out.println("Inserisci stringa X: ");
        //String inputStringX = input.nextLine();
        //char[] X = inputStringX.toCharArray();
        dimX = X.length;

        System.out.println("Inserisci stringa Y: ");
        //String inputStringY = input.nextLine();
        //char[] Y = inputStringY.toCharArray();
        dimY = Y.length;

        int[][] memo = new int[dimX+1][dimY+1];

        initMemo(memo, dimX, dimY);
        dimLcs = lcs(memo, X, Y, dimX, dimY);
        System.out.println("Lunghezza della LCS: " + dimLcs);

        //printMemo(memo, dimX, dimY);
    }
}
