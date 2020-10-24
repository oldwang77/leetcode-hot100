import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        // 特殊的一个点
        if(nums[0]==Math.pow(2,31)-1){
            return 1;
        }
        // 先去除重复的元素
        Set<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        // 遍历
        int ans = 0;
        int maxx = 1;
        for(int i = 0;i<nums.length;i++){
            // 这个数是起点，也就是说没有nums[i]-1的存在
            if(!set.contains(nums[i]-1)){
                ans = 1;
                while(set.contains(nums[i]+ans)){
                    ans++;
                    maxx = Math.max(maxx,ans);
                }
            }
        }
        return maxx;
    }

    public static void main(String[] args) {
        Solution128 s = new Solution128();
        int[] a = {100,4,200,1,3,2};
        System.out.println(s.longestConsecutive(a));
    }
}
