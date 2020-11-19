public class Solution494 {
    int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if (len == 0 && S != 0) {
            return 0;
        }

        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        dfs(nums, S, sum, 0, 0);
        return ans;
    }

    // 给定的时非负正整数
    public void dfs(int[] nums, int target, int[] sum, int cur, int cnt) {
        if (cur > nums.length) {
            return;
        }
        // sum[nums.length-1]-sum[cur-1]>0
        if (cur >= 1 && cnt + sum[nums.length - 1] - sum[cur - 1] < target) {
            return;
        }
        if (cur >= 1 && cnt - (sum[nums.length - 1] - sum[cur - 1]) > target) {
            return;
        }

        if (cnt == target && cur == nums.length) {
            ans++;
            return ;
        }
        if(cur>nums.length-1){
            return ;
        }

        dfs(nums, target, sum, cur + 1, cnt + nums[cur]);
        dfs(nums, target, sum, cur + 1, cnt - nums[cur]);
    }

    public static void main(String[] args) {
        Solution494 s = new Solution494();
        int[] nums = {1, 1, 1, 1, 1};
        int ans = s.findTargetSumWays(nums, 3);
        System.out.println(ans);
    }
}
