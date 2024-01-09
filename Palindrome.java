import java.util.Scanner;

public class Palindrome {
    public static void findMinInsertions(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int gap = 1; gap < n; ++gap) {
            for (int l = 0, h = gap; h < n; ++l, ++h) {
                dp[l][h] = (str.charAt(l) == str.charAt(h)) ? dp[l+1][h-1] : (Math.min(dp[l][h-1], dp[l+1][h]) + 1);
            }
        }

        System.out.println(dp[0][n-1]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while(n-- > 0){
            String s = scan.next();
            findMinInsertions(s);
        }
    }
}
    

