/**
 * 状态机
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[][] dp = new int[len][3];
        //dp[i][0]：第i天，手里没有持有，可以买，最大值
        //dp[i][1]：第i天，手里持有，可以卖，最大值
        //dp[i][2]：第i天，手里没有持有，但是买不了，最大值

        // 注意这个初始值！！！
        dp[0][0] = -prices[0];

        for (int i = 1; i < len; i++) {
            // i=1，相当于第二天
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        int ans = Math.max(dp[len - 1][1], dp[len - 1][2]);
        return ans;
    }

    public static void main(String[] args) {
        Solution309 s = new Solution309();
        int[] a = {1, 2, 3, 0, 2};
        s.maxProfit(a);
    }
}


// public class Solution309 {
//     int maxx = 0;
//
//     public int maxProfit(int[] prices) {
//         int len = prices.length;
//         if (len == 0) {
//             return 0;
//         }
//         dfs(prices, 0, 0, 0);
//         return maxx;
//     }
//
//     public void dfs(int[] prices, int value, int day, int flag) {
//         if (day == prices.length) {
//             maxx = Math.max(value, maxx);
//             return;
//         }
//         // 今天不是冰冻，那么今天可以买入,并且将flag设置为1，表示进入冷冻期
//         // flag -1 , 0 , 1 表示 啥也不做，可以买入，冷却区
//
//         // 买入股票
//         if (flag == 0) {
//             dfs(prices, value - prices[day], day + 1, 1);
//
//         }
//         // 卖出股票
//         if (flag == 1) {
//             dfs(prices, value + prices[day], day + 1, -1);
//         }
//
//         // 这个地方出错了，flag=>0 or 1
//         dfs(prices, value, day + 1, 0);
//         //dfs(prices, value, day + 1, 1);
//     }
//
//     public static void main(String[] args) {
//         Solution309 s = new Solution309();
//         int[] a = {1, 2, 4};
//         s.maxProfit(a);
//     }
// }
