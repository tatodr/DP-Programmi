import java.util.Scanner;

/**
 * La funzione LIS "Longest Increasing Subsequence" dato un array di numeri interi, trova la lunghezza della sotto-sequenza crescente più lunga.
 *
 * Esempio:
 * array = [10 22 9 33 21 50 41 60 80]
 * la sottosequienza crescente più lunga è [10,22,33,50,60,80]
 *
 * COMPLESSITÀ: O(N^2) -- due cicli for annidati che scorrono per dim valori
 */

public class LIS {

    static int lis(int[] memo, int[] array, int dim){

        if(dim == 0){
            return 0;
        }

        if(dim == 1){
            return 1;
        }

        for(int i=0; i<dim-1; i++){
            memo[i] = 1;
            for(int j=0; j<dim-1; j++){
                if(array[i] > array[j]){
                    memo[i] = Math.max(memo[i], 1+memo[j]);
                }
            }
        }

        int maxLength = 0;
        for (int len : memo) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;

    }

    static void initMemo(int[] memo, int dim){
        for(int i=0; i<dim; i++){
            memo[i] = 0;
        }
    }

    static void printMemo(int[] memo, int dim) {
        for (int j = 0; j < dim; j++) {
            System.out.print(memo[j] + " ");
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int dim = 0;

        System.out.println("Quanti numeri ha la tua sequenza? ");
        dim = input.nextInt();
        int[] array = new int[dim];

        System.out.println("Inserisci i tuoi numeri: ");
        for(int i=0; i<dim; i++){
            array[i] = input.nextInt();
        }

        int[] memo = new int[dim+1];

        initMemo(memo, dim);
        System.out.println("Lunghezza del sotto array: " + lis(memo, array, dim));
        //printMemo(memo, lis(memo, array, dim));
    }
}
