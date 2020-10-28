public class Solution279 {
    public int numSquares(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 比如4 = 1 + 1 + 1 + 1
            // 任意一个数字最差情况下也可以由i个1组成
            dp[i] = i;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
