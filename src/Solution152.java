public class Solution152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = Integer.MIN_VALUE, maxx = 1,minn = 1;
        for (int i = 0; i < len; i++) {
            // 只要nums[i]<0,无论此时的minn是正数还是负数，都需要进行交换
            // 因此此时minn*nums[i]一定大于maxx*nums[i]
            if (nums[i] < 0) {
                int t = maxx;
                maxx = minn;
                minn = t;
            }
            // 当出现0的情况，可能造成nums[i]比maxx大
            maxx = Math.max(nums[i] * maxx, nums[i]);
            minn = Math.min(nums[i] * minn, nums[i]);
            max = Math.max(maxx,max);
        }
        return max;
    }
}
