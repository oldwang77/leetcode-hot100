import java.util.LinkedList;
import java.util.List;

public class Solution39 {
    // 组合数
    // dfs+回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new LinkedList<>();
        List<Integer> lst = new LinkedList<>();
        int idx = 0;
        dfs(candidates,target,lists,lst,idx);
        return lists;
    }

    public void dfs(int[] candidates,int target,List<List<Integer>> lists,List<Integer> ans,int idx){
        // 存储结果
        if(target==0){
            // 为什么这里new LinkedList<>()呢？
            //lists.add(ans);
            lists.add(new LinkedList<>(ans));
            return ;
        }

        if(idx==candidates.length){
            return ;
        }

        // 直接跳过
        dfs(candidates,target,lists,ans,idx+1);
        if(target-candidates[idx]>=0){
            ans.add(candidates[idx]);
            // 因为数字可以重复使用，所以这里就是idx
            dfs(candidates,target-candidates[idx],lists,ans,idx);
            // 回溯
            ans.remove(ans.size()-1);
        }

        // System.out.println(lists);
    }

    public static void main(String[] args) {
        Solution39 s = new Solution39();
        int[] a = {2,3,6,7};

        s.combinationSum(a,7);

    }
}
