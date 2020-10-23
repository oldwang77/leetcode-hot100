import java.util.LinkedList;

public class Solution75 {

    public void sortColors(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.addFirst(nums[i]);
                ans++;
            } else if (nums[i] == 2) {
                list.addLast(nums[i]);
            }
        }
        // 把1加进去就可以了
        int cnt = nums.length - list.size();
        for (int i = 0; i < nums.length; i++) {
            if (i < ans) {
                nums[i] = 0;
            } else if (i < ans + cnt) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
