import java.util.Scanner;
import java.util.ArrayList;

public class zaino {

    static int[][] memo;

    static int knapsack(int[] valori, int[] pesi, int capacita, int dim) {

        if (capacita == 0 || dim < 0)
            return 0;

        if (memo[dim][capacita] != 0)
            return memo[dim][capacita];

        if (pesi[dim] > capacita)
            return memo[dim][capacita] = knapsack(valori, pesi, capacita, dim - 1);
        else
            return memo[dim][capacita] = Math.max(valori[dim] + knapsack(valori, pesi, capacita - pesi[dim], dim - 1),
                    knapsack(valori, pesi, capacita, dim - 1));
    }

    static void initMemo(int dim, int capacita) {
        memo = new int[dim][capacita];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < capacita; j++) {
                memo[i][j] = 0;
            }
        }
    }

    static void printMemo(int dim) {
        for (int i = 0; i < dim; i++)
            System.out.print(memo[i] + " ");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casiTest = 0;
        //ArrayList<Integer> numeri = new ArrayList<>();

        System.out.print("Inserisci numero casi test: ");
        casiTest = input.nextInt();

        while(casiTest!=0) {
            int capacitaZaino = 0;
            int dim = 0;

            System.out.print("Inserisci capacità dello zaino: ");
            capacitaZaino = input.nextInt();

            System.out.print("Inserisci numero di elementi da considerare: ");
            dim = input.nextInt();
            int[] pesi = new int[dim];
            int[] valori = new int[dim];

            System.out.print("Inserisci pesi: ");
            for(int i=0; i<dim; i++){
                pesi[i] = input.nextInt();
            }

            System.out.print("Inserisci valori: ");
            for(int j=0; j<dim; j++){
                valori[j] = input.nextInt();
            }

            initMemo(dim, capacitaZaino + 1);
            System.out.println("Massimo valore ottenibile: " + knapsack(valori, pesi, capacitaZaino, dim - 1));
            //printMemo(dim);

            casiTest--;
        }
    }
}