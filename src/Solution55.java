public class Solution55 {
    public boolean canJump(int[] nums) {
        // 贪心
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(i>k) {
                return false;
            }
            // k记录了下一步能跳到的最大的位置
            k = Math.max(k,nums[i]+i);
        }
        return true;
    }
}
