import java.util.Scanner;

public class CambiMonete {

    public static long cambio(int[] monete, int m, int centesimi, long[][] memo){
        if(centesimi == 0){
            return 1;
        }

        if(centesimi < 0 || m <=0){
            return 0;
        }

        if(memo[m][centesimi] != -1){
            return memo[m][centesimi];
        }
        //ho due possibilità: prendere la moneta più grande o non prenderla
        if(centesimi < monete[m-1]){
            return memo[m][centesimi] = cambio(monete, m-1, centesimi, memo);//non prendo la moneta
        }else{ //altrimenti prendo la moneta più grande e quella prima di essa
            return memo[m][centesimi] = cambio(monete, m-1, centesimi, memo) + cambio(monete, m, centesimi - monete[m-1], memo);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] monete = {1,5,10,25,50};
        int m = monete.length;
        long[][] memo = new long[m+1][7500];
        for(int i=0; i<=m; i++){
            for(int j=0; j<7500; j++){
                memo[i][j] = -1;
            }
        }
        int ncasi = s.nextInt();
        while(ncasi-- > 0){
            int centesimi = s.nextInt();
            System.out.println(cambio(monete, m, centesimi, memo));
        }
    }
}