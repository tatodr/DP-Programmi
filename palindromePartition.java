import java.util.Objects;
import java.util.Scanner;

public class palindromePartition {

    static int MAX_VALUE = 100000;

    public static int partitionNumber(int[][] memo, String stringa, int indice, int dim){

        if(indice >= dim){
            return 0;
        }

        if(memo[indice][dim] != MAX_VALUE){
            return memo[indice][dim];
        }

        if(isPalindrome(stringa.substring(indice, dim))) {
            return  memo[indice][dim] = 0;
        }

        else{
            for(int i=indice; i<dim; i++){
                memo[indice][dim] = Math.min(memo[indice][dim], (partitionNumber(memo, stringa, indice, i) +
                        partitionNumber(memo, stringa, i+1, dim) + 1));
            }
        }

        return memo[indice][dim];
    }

    public static boolean isPalindrome(String stringa){
        int dim = stringa.length();


        for(int i=0; i<dim; i++){
                if(stringa.charAt(i) != stringa.charAt(dim-1-i)){
                    return false;
            }
        }
        return true;
    }

    public static void initMemo(int[][] memo, int dim){
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                memo[i][j] = MAX_VALUE;
            }
        }
    }

    public static boolean isSafe(String stringa){
        int dim = stringa.length();
        if (dim<1 || dim>1000){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int casiTest = 0;

        System.out.println("Inserisci numero casi test: ");
        casiTest = input.nextInt();
        input.nextLine();

        while(casiTest!=0){
            String stringa = new String();
            int dim = 0;
            int numero = 0;

            System.out.println("Inserisci stringa: ");

            stringa = input.nextLine();
            dim = stringa.length();

            int[][] memo = new int[dim][dim];

            if(isSafe(stringa)){
                initMemo(memo, dim);
                numero = partitionNumber(memo, stringa, 0, dim-1);

                System.out.println("La stringa può essere suddivisa in " + numero + " gruppi palindromi.");

                System.out.println("\n");
            }

            casiTest--;
        }

    }

}
