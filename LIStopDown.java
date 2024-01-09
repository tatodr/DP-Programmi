import java.util.ArrayList;
import java.util.Scanner;

/**
 * Approccio TOP DOWN
 * La funzione LIS "Longest Increasing Subsequence" dato un array di numeri interi, trova la lunghezza della sotto-sequenza crescente più lunga.
 *
 * Esempio:
 * array = [10 22 9 33 21 50 41 60 80]
 * la sottosequienza crescente più lunga è [10,22,33,50,60,80]
 *
 * Output: 6
 *
 * COMPLESSITÀ: O(N^2) nel caso pessimo
 */

public class LIStopDown {

    public static int findMax(ArrayList<Integer> array, int dim, ArrayList<Integer> stampa){
        int maxSomma = 0;

        for(int i=0; i<dim; i++){
            //parto dal secondo elemento della lista
            int j = i+1;
            //parto sommando due elementi, quindi sarà sempre 1+x
            int somma = 1;

            while(array.get(i)<array.get(j) && j<dim){
                somma++;
                j++;

                //stampa.add(array.get(i));
            }

            if(somma > maxSomma){
                maxSomma = somma;
            }
        }

        return maxSomma;
    }

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        System.out.println("Inserisci casi test: ");
        casiTest = input.nextInt();

        while(casiTest != 0){
            ArrayList<Integer> array = new ArrayList();
            ArrayList<Integer> stampa = new ArrayList<>();
            int dim = 0;
            int maxSeq = 0;

            System.out.println("Quanti numeri vuoi inserire?");
            dim = input.nextInt();

            System.out.println("Inserisci la sequenza: ");
            for(int i=0; i<dim; i++){
                array.add(input.nextInt());
            }

            maxSeq = findMax(array, dim-1, stampa);
            System.out.println("La masimma sottosequenza è di " + maxSeq + " elementi.");

            for(int i=0; i<dim; i++){
                System.out.println(stampa.get(i));
            }

            casiTest--;
        }
    }
}
