import java.util.ArrayList;
import java.util.List;
// 前序遍历
public class Solution114 {
    List<TreeNode> ans = new ArrayList<>();

    public void flatten(TreeNode root) {
        dfs(root);
        for(int i=0;i<ans.size();i++){
            ans.get(i).left=null;
            if(i==ans.size()-1){
                ans.get(i).right=null;
            }else{
                ans.get(i).right = ans.get(i+1);
            }
        }
    }

    public void dfs(TreeNode node){
        if(node==null) return ;
        ans.add(node);
        dfs(node.left);
        dfs(node.right);
    }
}
