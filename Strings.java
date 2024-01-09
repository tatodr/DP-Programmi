import java.util.Scanner;

public class Strings {
    static int MOD = 10007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int test = 0; test < t; test++) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            String s3 = scanner.next();

            int len1 = s1.length();
            int len2 = s2.length();
            int len3 = s3.length();

            int[][] dp = new int[len1 + 1][len2 + 1];
            dp[0][0] = 1;

            for (int i = 0; i <= len1; i++) {
                for (int j = 0; j <= len2; j++) {
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                    }
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
                    }
                }
            }

            System.out.print(dp[len1][len2] + " ");
        }
    }
}
