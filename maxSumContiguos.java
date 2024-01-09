import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calcola la massima somma tra numeri contigui
 *
 * Esempio:
 * -2, -3, 4, -1, -2, 1, 5, -3
 * Massima somma: 7
 */

public class maxSumContiguos {
    public static final int MAX_VALUE = 1000000;

    public static int maxSomma(int[][] memo, int[] numeri, int dim, int indice){
        int somma = 0;

        if(dim < 0 || indice > dim){
            return 0;
        }

        if(memo[indice][dim] != MAX_VALUE){
            return memo[indice][dim];
        }

        for(int i=indice; i<dim; i++){
            somma += numeri[i];
        }

        return memo[indice][dim] = Math.max(somma, Math.max(maxSomma(memo, numeri, dim-1, indice),
                        maxSomma(memo, numeri, dim, indice+1)));
    }

    static void initMemo(int[][] memo, int dim){
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                memo[i][j] = MAX_VALUE;
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        System.out.println("Quanti casi test?");
        casiTest = input.nextInt();

        while(casiTest != 0){
            int dim = 0;
            int somma = 0;

            System.out.println("Quanti numeri vuoi inserire?");
            dim = input.nextInt();

            int[] numeri = new int[dim];
            int[][] memo = new int[dim][dim];

            System.out.println("Inserisci sequenza: ");
            for(int i=0; i<dim; i++){
                numeri[i] = input.nextInt();
            }

            initMemo(memo, dim);
            somma = maxSomma(memo, numeri, dim-1, 0);

            System.out.println("Massima somma contigua: " + somma);

            casiTest--;
        }

    }

}