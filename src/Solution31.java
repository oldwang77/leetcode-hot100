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
        int i = num.length - 2;
        while (i >= 0 && nums[i] >= num[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && num[j] <= num[i]) {
                j--;
            }
            change(num, i, j);
        }

        // [i+1,num.length-i]全部进行翻转
        int start = i + 1, end = num.length - 1;
        while (start < end) {
            change(num, start, end);
            start++;
            end--;
        }
        for (int k = 0; k < num.length; k++) {
            nums[k] = num[k];
        }
        return;
    }

    public void change(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }

    public static void main(String[] args) {
        Solution31 s = new Solution31();
        int[] a = {1, 2, 3};
        s.nextPermutation(a);
    }
}
