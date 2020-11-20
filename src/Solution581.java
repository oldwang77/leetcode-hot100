public class Solution581 {
    // 无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int maxx = nums[0];
        int minn = nums[len - 1];
        int begin = 0, end = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= maxx) {
                maxx = nums[i];
            } else {
                // 最后一个小于max的位置
                end = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {

            if (nums[i] <= minn) {
                minn = nums[i];
            } else {
                // 最先的大于min的位置
                begin = i;
            }
        }
        return begin == end ? 0:end - begin + 1;
    }
}
