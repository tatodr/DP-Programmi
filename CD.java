
/**
 5 3 1 3 4
 10 4 9 8 4 2
 20 4 10 5 7 4
 90 8 10 23 1 2 3 4 5 7 
 45 8 4 10 44 43 12 9 8 2
 */
import java.util.Scanner;

public class CD {
    public static int N = 20; //numero massima di brani su CD
    
    

    public static void initMemo(int[][] memo, int n, int ntracce){
        
        for(int i=0; i<n; i++){
            
            for(int j=0; j<ntracce; j++){
                
                memo[i][j] = -1;
                
            }
        }
    }

    public static int CD(int[] duratabrani, int ntracce, int[][] memo, int n, int i){

        if(i < 0) {
        	
            return 0;
        }

        if(memo[n][ntracce] != -1){
        	
            return memo[n][ntracce];
        }

         
        // //memo[ntracce][ntracce] = 0;
        if( n >= duratabrani[i]){
           
            return memo[n][ntracce] = Math.max(duratabrani[i] + CD(duratabrani,ntracce,memo,n-duratabrani[i], i-1), 
            											CD(duratabrani,ntracce,memo,n, i-1));
        
        }else{
            
            return memo[n][ntracce] = CD(duratabrani,ntracce,memo,n, i-1);
        }
        
        

    }
    public static void main(String[] args) {
        int ncasi = 0;
        Scanner s = new Scanner(System.in);

        ncasi = s.nextInt();

        while(ncasi-- > 0){
        	
            int n = s.nextInt();//durata massima di brani
            
            int ntracce = s.nextInt();//numero di tracce
            
            int[] duratabrani = new int[ntracce];
            
            for (int i = 0; i < ntracce; i++) {
            	
                duratabrani[i] = s.nextInt();
                
//                if(duratabrani[i] > N){
//                	
//                    System.out.println("errore");
//                    
//                    return;
//                }
            }
            
            int[][] memo = new int[n+1][ntracce+1];
            
            initMemo(memo, n+1 ,ntracce+1);

            int res = CD(duratabrani, ntracce, memo, n, ntracce-1);
            
            
            System.out.println("durata: "+res);
        }
    }
}
