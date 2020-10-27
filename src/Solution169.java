public class Solution169 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);

        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int result = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            int ans = 0;
            for (int j = 0; j <= i - 2; j++) {
                ans = Math.max(ans, dp[j]);
            }
            dp[i] = ans + nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution169 s = new Solution169();
        int[] a = {2, 7, 9, 3, 1};
        System.out.println(s.rob(a));
    }
}
