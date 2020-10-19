import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution31 {
    // 下一个排列
    public void nextPermutation(int[] nums) {
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            num[i] = nums[i];
        }

        int len = nums.length;
        boolean flag = false;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                flag = true;
            }
        }
        // 这个序列就是最大的序列
        // 那么返回最小的序列
        if (!flag) {
            Arrays.sort(nums);
            return;
        }
        // 此时一定存在下一个排列
        int i = num.length - 1;
        while (i >= 1 && nums[i - 1] >= num[i]) {
            i--;
        }
        int j = 0;
        if (i >= 0) {
            while (j < num.length && num[j] > num[i]) {
                j--;
            }
        }


        for (int i = 0; i < num.length; i++) {
            nums[i] = num[i];
        }
        return;
    }

    public static void main(String[] args) {
        Solution31 s = new Solution31();
        int[] a = {1, 3, 2};
        s.nextPermutation(a);
    }
}
