import java.util.Scanner;

public class coinCombo {

    public static int count(int[] monete, int numMonete, int somma) {
        if (somma == 0) {
            return 1;
        }

        if (somma < 0 || numMonete <= 0) {
            return 0;
        }

        return count(monete, numMonete - 1, somma) + count(monete, numMonete, somma - monete[numMonete - 1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numMonete = 0;
        int somma = 0;

        System.out.println("Inserisci numero monete: ");
        numMonete = input.nextInt();

        System.out.println("Inserisci monete: ");
        int[] monete = new int[numMonete];
        for(int i=0; i<numMonete; i++){
            monete[i] = input.nextInt();
        }

        System.out.println("Inserisci la somma che vuoi raggiungere: ");
        somma = input.nextInt();

        System.out.println("Numero di modi: " + count(monete, numMonete, somma));
    }

}