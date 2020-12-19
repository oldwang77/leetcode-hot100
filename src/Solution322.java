//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Solution322 {
//<<<<<<< Updated upstream
//=======
//<<<<<<< HEAD
//    public int coinChange(int[] coins, int amount) {
//        Integer[] arr = {5,4,7,9,2,12,54,21,1};
//        //降序
//        Arrays.sort(arr, new Comparator<Integer>() {
//            public int compare(Integer a, Integer b) {
//                return b-a;
//            }
//        });
//
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        System.out.println(Arrays.toString(arr));
//
//        return 1;
//=======
//>>>>>>> Stashed changes
//
//    public int coinChange(int[] coins, int amount) {
//        int maxx = amount + 1;
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, maxx);
//        dp[0] = 0;
//
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if (coins[j] <= i) {
//                    // dp[i]表示兑换i需要的最少硬币数目
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
//        return dp[amount] > amount ? -1 : dp[amount];
//<<<<<<< Updated upstream
//=======
//>>>>>>> origin/master
//>>>>>>> Stashed changes
//    }
//}
