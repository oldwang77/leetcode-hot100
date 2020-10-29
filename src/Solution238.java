public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
            ans[i] = ans[i] * left;
            left = left * nums[i];
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            ans[j] = ans[j] * right;
            right = right * nums[j];
        }
        return ans;
    }
}
