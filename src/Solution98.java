import java.util.LinkedList;
import java.util.List;

public class Solution98 {
    // 验证是不是二叉搜索树
    // 中序遍历有序
    List<Integer> lst = new LinkedList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        dfs(root);
        for(int i=0;i<lst.size()-1;i++){
            if(lst.get(i+1)<=lst.get(i)){
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode node){
        if(node==null) return ;
        dfs(node.left);
        lst.add(node.val);
        dfs(node.right);
    }

}
