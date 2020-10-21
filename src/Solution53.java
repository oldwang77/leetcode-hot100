public class Solution53 {
    // 最大子序列的和
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int ans = 0;
        int maxx = -0x7f7f7f;
        for(int i=0;i<nums.length;i++){
            if(ans>=0){
                ans = ans + nums[i];
            }else{
                ans = nums[i];
            }
            maxx = Math.max(ans,maxx);
        }
        return maxx;
    }
}
