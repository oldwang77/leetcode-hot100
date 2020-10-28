public class Solution287 {
    // 寻找重复的数
    // 时间换空间，二分查找

    /**
     * 区间 [1, 7][1,7] 的中位数是 4，遍历整个数组，统计小于等于 4 的整数的个数，
     * 如果不存在重复元素，最多为 44 个。等于 44 的时候区间 [1, 4][1,4] 内也可能有重复元素。
     * 但是，如果整个数组里小于等于 4 的整数的个数严格大于 44 的时候，就可以说明重复的数存在于区间 [1, 4][1,4]。
     * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
     */

    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 统计数组中大于mid的个数
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }

            if (cnt <= mid) {
                left = mid + 1;
            } else if (cnt > mid) {
                right = mid;
            }
        }
        return left;
    }
}
