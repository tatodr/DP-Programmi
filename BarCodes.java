import java.util.Scanner;

public class BarCodes {

    public static void init(int[][] memo, int n,int k){
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                memo[i][j] = -1;
            }
        }
    }

    private static int barCodes(int n, int k, int m, int[][] memo) {
        if(n==0 && k==0) return 1;

        if (n == 0 || k == 0) return 0;

        if(memo[n][k] != -1) return memo[n][k];     

        memo[n][k] = 0;
        for(int i=1; i<=m; i++){
            
           if (n >= i) {
                memo[n][k] +=  barCodes(n-i,k-1,m,memo);
            }
            
        }

        return memo[n][k];
    }

    public static void main(String[] args) {
        int ncase = 0;
        Scanner s = new Scanner(System.in);

        ncase = s.nextInt();
        while(ncase-- > 0){

            int n = 0;  //numero di barre totali
            int k = 0; //numero di gruppi che posso avere
            int m = 0; //nuemro di barre dello stesso tipo per gruppo 

            n = s.nextInt();
            k = s.nextInt();
            m = s.nextInt();

            if(n<0 || k<0 || m<0 || n>100 || k>100 || m>100){
                System.out.println("Errore");
                System.exit(0);
            }

            int[][] memo = new int[n+1][k+1];
            init(memo,n+1,k+1);
            
            
            System.out.println(barCodes(n,k,m,memo));

        }

    }
    
}
