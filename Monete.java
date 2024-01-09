import java.util.Scanner;

public class Monete {

    public static void initmemo(int[] memo){
        for(int i = 0; i < memo.length; i++){
            memo[i] = -1;
        }
    }

    public static int minMonete(int[] monete, int[] memo, int importo, int dim){
        if(importo < 0) return -1;
        if(importo == 0) return 0;
        if(memo[dim] != -1) return memo[dim];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < monete.length; i++){
            int res = minMonete(monete, memo, importo - monete[i],dim);
            if(res >= 0 && res < min){
                min = 1 + res;
            }
        }
        memo[dim] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[dim];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while(n != 0){
            int dim = s.nextInt();
            int[] monete = new int[dim];
            for(int i = 0; i < dim; i++){
                monete[i] = s.nextInt();
            }
            int importo = s.nextInt();
            int[] memo = new int[dim + 1];
            initmemo(memo);
            int res = minMonete(monete, memo, importo,dim);
            System.out.println(res);
        
            n--;
        }
    }
}