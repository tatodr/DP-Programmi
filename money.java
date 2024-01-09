import java.util.Arrays;

public class money {
    
        public static int minCoins(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }

        public static void main(String[] args) {
            int[] coins = {40, 10, 10, 10};
            int amount = 50;
            System.out.println(minCoins(coins, amount));  // Output: 2
        }
    
}
