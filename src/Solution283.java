import java.util.ArrayList;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                ans.add(nums[i]);
                cnt++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < cnt) {
                nums[i] = ans.get(i);
            } else {
                nums[i] = 0;
            }
        }
    }
}
