import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        List<Integer> lst = new ArrayList<>();
        for (int x : nums) {
            lst.add(x);
        }
        Collections.sort(lst);
        for (int i = 0; i < lst.size(); i++) {
            // 排序好了，当前第一个元素>0，那么不可能最后结果=0
            if (lst.get(i) > 0) {
                break;
            }
            // 如果元素相同，那么后面元素的情况已经被包含
            if (i != 0 && lst.get(i).equals(lst.get(i - 1))) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = lst.get(left) + lst.get(right) + lst.get(i);
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(lst.get(i));
                    tmp.add(lst.get(left++));
                    tmp.add(lst.get(right--));
                    // 避免重复
                    while (left<right && lst.get(left).equals(lst.get(left - 1))) {
                        left++;
                    }
                    while (left<right && lst.get(right).equals(lst.get(right + 1))) {
                        right--;
                    }
                    list.add(tmp);
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(a));
    }
}
