import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, path, 0);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> path, int cur) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // 当前结点加入
        path.add(nums[cur]);
        dfs(nums, path, cur + 1);
        path.remove(path.size() - 1);
        // 当前结点不加入，直接跳过
        dfs(nums, path, cur + 1);

    }
}
