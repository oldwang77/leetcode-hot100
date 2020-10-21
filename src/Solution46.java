import java.util.LinkedList;
import java.util.List;

// dfs+回溯
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        // 保存叶子的访问状态
        boolean[] used = new boolean[nums.length];

        dfs(nums, lst, ans, 0, used);
        return lst;
    }

    public void dfs(int[] nums, List<List<Integer>> lists, List<Integer> ans, int depth, boolean[] used) {
        if (depth == nums.length) {
            lists.add(new LinkedList<>(ans));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                ans.add(nums[i]);
                used[i] = true;
                dfs(nums, lists, ans, depth+1,used);
                used[i]=false;
                ans.remove(ans.size()-1);
            }
        }
    }
}
