public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;  // 如果t1为空，那么合并后的结果就是t2
        }
        if(t2==null){
            return t1;  // 如果t2为空，那么合并后的结果就是t1
        }
        TreeNode node = new TreeNode(t1.val+t2.val);
        node.left = mergeTrees(t1.left,t2.left);
        node.right = mergeTrees(t1.right,t2.right);
        return node;
    }
}
