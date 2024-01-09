import java.util.ArrayList;
import java.util.Scanner;

/**
 * Il programma dei papi
 * riceve in ingresso i numero di anni Y entro cui valutare quanti papi si sono successi, e il numero P di papi che ci sono stati.
 * Ritorna il massimo numero di papi successi nel range di Y anni + l'anno del primo papa nel range Y + anno dell'ultimo papa in Y
 *
 * Esempio:
 * Y: 5
 * P: 20
 * 1
 * 2
 * 3
 * 6
 * 8
 * 12
 * 13
 * 13
 * 15
 * 16
 * 17
 * 18
 * 19
 * 20
 * 20
 * 21
 * 25
 * 26
 * 30
 * 31
 *
 * Output: 6 16 20
 *
 *
 * COMPLESSITÀ:  O(P^2) -- due cicli che scorrono su tutto il numero dei papi P(=dim)
 */

public class popesTopDown {

    public static boolean isSafe(ArrayList<Integer> years, int p, int y, int dim) {
        return (p < 1000000) && (dim > 0) && (dim <= p) && (y < 1000000);
    }

    public static int numberPopes(ArrayList<Integer> popes, int y, int dim, int[] annoInizio, int[] annoFine) {
        int countMax = 0;

        for (int i = 0; i < dim; i++) {
            int count = 0;
            int j = i;

            while (j<dim && popes.get(j) < popes.get(i)+y) {
                count++;
                j++;
            }

            if (count > countMax) {
                countMax = count;
                annoInizio[0] = popes.get(i);
                annoFine[0] = popes.get(j-1);
            }

        }

        return countMax;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        System.out.println("Inserisci numero casi test: ");
        casiTest = input.nextInt();

        while ((casiTest != 0)) {
            int y = 0;
            int p = 0;
            int dim = 0;
            int numero = 0;

            ArrayList<Integer> years = new ArrayList<>();

            System.out.println("Inserisci Y: ");
            y = input.nextInt();

            System.out.println("Inserisci P: ");
            p = input.nextInt();
            dim = p;

            System.out.println("Inserisci sequenza: ");

            for (int i = 0; i < p; i++) {
                years.add(input.nextInt());
            }

            int[] annoInizio = new int[1];
            int[] annoFine = new int[1];

            if (isSafe(years, p, y, dim)) {
                numero = numberPopes(years, y, dim, annoInizio, annoFine);
                System.out.println(numero + " " + annoInizio[0] + " " + annoFine[0]);

            }

            System.out.println("\n");

            casiTest--;
        }
    }
}
