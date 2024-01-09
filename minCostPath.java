import java.util.Scanner;

/**
 * L'algoritmmo MinCostPath trova il percorso con il costo minimo attraverso una matrice (quadrata).
 * Ogni cella della matrice ha associato un costo.
 * Trovare il percorso con il costo complessivo minimo.
 *
 * Esempio:
 * Matrice dei Costi:
 * {1, 3, 1}
 * {2, 8, 6}
 * {5, 3, 4}
 *
 * Percorso con il costo minimo: 10
 *
 * COMPLESSITÀ esponenziale, dovuta dell'algoritmo di memoizzazione
 * senza memoizzazione:  O(3^(r+c)) --- ogni passo ho 3 chiamate ricorsive
 * con memoizzazione: O(r*c) --- ogni sottoproblema viene calcolato e memorizzato 1 sola volta
 */

public class minCostPath {

    static int minCostPath(int[][] memo, int[][] matrice, int r, int c){
        //inizializzo prima riga della matrice memo
        memo[0][0] = matrice[0][0];

        //inizializzo la prima riga della matrice memo
        for (int i = 1; i < r; i++) {
            memo[i][0] = memo[i - 1][0] + matrice[i][0];
        }

        //inizializzo la prima colonna della matrice memo
        for (int j = 1; j < c; j++) {
            memo[0][j] = memo[0][j - 1] + matrice[0][j];
        }

        if(r < 0 || c < 0){
            return 0;
        }

        if(memo[r][c] != -1){
            return memo[r][c];
        }

        else{
            memo[r][c] = matrice[r][c] + min3op(minCostPath(memo, matrice, r-1, c),
                    minCostPath(memo, matrice, r, c-1), minCostPath(memo, matrice, r-1, c-1));
        }

        return  memo[r][c];
    }

    static void initMemo(int[][] memo, int r, int c){
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }
    }

    static int min3op(int a, int b, int c){
        return Math.min(a, Math.min(b,c));
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int righe = 0;
        int colonne = 0;

        System.out.println("Inserisci numero righe e colonne: ");
        righe = input.nextInt();
        colonne = input.nextInt();

        int[][] matrice = new int[righe][colonne];

        System.out.println("Inserisci matrice: ");
        for(int i=0; i<righe; i++){
            for (int j=0; j<colonne; j++){
                matrice[i][j] = input.nextInt();
            }
        }

        int[][] memo = new int[righe][colonne];
        initMemo(memo, righe, colonne);

        System.out.println("Il cammino minimo è: " + minCostPath(memo, matrice, righe-1, colonne-1));
    }
}
