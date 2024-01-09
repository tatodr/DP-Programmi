import java.util.Scanner;

/**
 * Supponiamo di avere un insieme di monete di diversi tagli e una somma obiettivo.
 * L'obiettivo è determinare il numero di modi unici per ottenere la somma desiderata utilizzando le monete disponibili.
 * Ogni moneta può essere utilizzata un numero illimitato di volte.
 *
 * Esempio:
 * Considera un sistema di monete con tagli di 1, 2 e 5, e l'obiettivo è ottenere una somma di 5.
 *
 * I modi unici per raggiungere questa somma sono:
 * 1+1+1+1+1
 * 1+1+1+2
 * 1+2+2
 * 5
 */

public class coinComboDP {

    public static int calcoloSomma(int[] monete, int somma, int numMonete){
        int[] memo = new int[somma + 1];
        memo[0] = 1;

        if(somma == 0) return 0;
        if(somma == 1) return 1;

        else if (somma !=0 && somma != 1){
            for(int i=0; i<numMonete; i++){
                for (int j = monete[i]; j <= somma; j++) {
                    memo[j] += memo[j-monete[i]];
                }
            }
        }

        return memo[somma];
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numMonete = 0;
        int somma = 0;
        int casiTest = 0;

        System.out.println("Inserisci numero casi di test: ");
        casiTest = input.nextInt();

        while(casiTest != 0){
            System.out.println("Inserisci numero monete: ");
            numMonete = input.nextInt();

            System.out.println("Inserisci monete: ");
            int[] monete = new int[numMonete];
            for(int i=0; i<numMonete; i++){
                monete[i] = input.nextInt();
            }

            System.out.println("Inserisci somma: ");
            somma = input.nextInt();

            System.out.println("Numero di modi: " + calcoloSomma(monete, somma, numMonete));

            casiTest--;
        }

    }

}
