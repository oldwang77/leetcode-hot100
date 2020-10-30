public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution300 s = new Solution300();
        int[] a = {10,9,2,5,3,7,101,18};
        s.lengthOfLIS(a);
    }
}
