import java.util.Arrays;
import java.util.Comparator;

public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        int maxx = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, maxx);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // dp[i]表示兑换i需要的最少硬币数目
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
