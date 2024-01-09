import java.util.Scanner;

public class CambiMoneteBottomUp {

    public static long cambio(int[] monete, int m, int centesimi){
        long[] dp = new long[centesimi + 1];
        dp[0] = 1; // c'è un solo modo per fare il cambio per 0 centesimi

        for(int i=0; i<m; i++){
            for(int j=monete[i]; j<=centesimi; j++){
                dp[j] += dp[j - monete[i]];
            }
        }

        return dp[centesimi];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] monete = {1,5,10,25,50};
        int m = monete.length;

        int ncasi = s.nextInt();
        while(ncasi-- > 0){
            int centesimi = s.nextInt();
            System.out.println(cambio(monete, m, centesimi));
        }
    }
}