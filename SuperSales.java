import java.util.Scanner;
import java.util.Arrays;

public class SuperSales {
    static int[] prices;
    static int[] weights;
    static int[][] dp;
    static final int MAX_WEIGHT = 30;
    static final int MAX_ITEMS = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            prices = new int[N];
            weights = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
            }
            int G = scanner.nextInt();
            int totalValue = 0;
            while (G-- > 0) {
                int MW = scanner.nextInt();
                dp = new int[N][MW + 1];
                for (int[] row : dp) {
                    Arrays.fill(row, -1);
                }
                totalValue += knapSack(N - 1, MW);
            }
            System.out.println(totalValue);
        }
        scanner.close();
    }

    static int knapSack(int i, int w) {
        if (i < 0 || w <= 0) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        if (weights[i] > w) {
            dp[i][w] = knapSack(i - 1, w);
        } else {
            dp[i][w] = Math.max(knapSack(i - 1, w), prices[i] + knapSack(i - 1, w - weights[i]));
        }
        return dp[i][w];
    }
}