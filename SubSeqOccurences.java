import java.util.Scanner;

public class SubSeqOccurences {
    public static void initMemo(int[][] memo){
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }
    }

    public static int Occorrenze(String X, String Z, int[][] memo, int i, int j){
        if(j == Z.length()){
            return 1;
        }
        if(i == X.length()){
            return 0;
        }

        if(memo[X.length()][Z.length()] != -1){
            return memo[X.length()][Z.length()];
        }

        /*Il tuo codice è quasi corretto, ma ci sono alcuni problemi che devono essere risolti:

        La condizione di base della ricorsione non è corretta. Se j (l'indice per la stringa Z) è uguale alla lunghezza di Z, allora hai trovato una sottosequenza e dovresti restituire 1. Se i (l'indice per la stringa X) è uguale alla lunghezza di X, allora hai esaurito la stringa X e non hai trovato una sottosequenza, quindi dovresti restituire 0.

        Quando i caratteri corrispondono, hai due opzioni: puoi includere quel carattere nella sottosequenza o saltarlo. Quindi, dovresti sommare le occorrenze di entrambe le opzioni.

        Quando i caratteri non corrispondono, l'unica opzione è saltare il carattere in X, quindi dovresti chiamare la funzione ricorsiva con i+1 e j.

        Infine, stai memorizzando il risultato nel memo in modo errato. Dovresti memorizzare il risultato in memo[i][j], non in memo[X.length()][Z.length()]. */
        if(Z.charAt(j) == X.charAt(i)){
            return memo[i][j] =   Occorrenze(X, Z, memo, i+1, j+1) + Occorrenze(X, Z, memo, i+1, j) ;
        }else{
           return  memo[i][j] = Occorrenze(X, Z, memo, i+1, j) ;
        }
       
    }
    public static void main(String[] args) {
        int ncasi = 0;
        Scanner s = new Scanner(System.in);

        ncasi = s.nextInt();

        while(ncasi != 0){
            String X = s.next();
            String Z = s.next();
            int[][] memo = new int[X.length()+1][Z.length()+1];
            initMemo(memo);
            System.out.println(Occorrenze(X, Z, memo, 0, 0));
            ncasi--;
        }
    }
}
