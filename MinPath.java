import java.util.Scanner;

public class MinPath {

    
    public static int minCostPath (int[][] memo, int[][] matrice, int r, int c ){
		    	
        if(r < 0 || c < 0) {
            return 0;
        }
        
        if(memo[r][c] != -1) {
            return memo[r][c];
        }else {
            return memo[r][c] = min3(minCostPath(memo, matrice, r, c-1),minCostPath(memo, matrice, r-1, c-1),minCostPath(memo, matrice, r-1, c));
        }
        
    }

    public static void initMemo(int[][] memo, int r, int c){
        for(int i = 0; i < r; i++){
            for (int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }
    }
    
    public static int min3(int a, int b, int c) {
        return Math.min(a ,Math.min(b, c));
    }

    public static void main () {
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
