import java.util.ArrayList;
import java.util.Arrays;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int cnt = 0;

        ArrayList<Integer> lst = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            lst.add(nums[i]);
        }
        if(!lst.contains(target)){
            res[0]=-1;
            res[1]=-1;
            return res;
        }


        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[1] = right;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        res[0] = left;
        return res;
    }

    public static void main(String[] args) {
        Solution34 s = new Solution34();
        int[] nums = {5, 7, 7, 8, 8, 10};
        s.searchRange(nums, 8);
    }
}
