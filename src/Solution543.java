public class Solution543 {
    // 二叉树的 每个节点的左右子树的高度和 的最大值。
    int maxx = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return maxx;
    }

    public void dfs(TreeNode node){
        if(node==null) return ;
        int ans1 = depth(node.left);
        int ans2 = depth(node.right);
        int ans = Math.max(Math.max(ans1,ans2),ans1+ans2);
        maxx = Math.max(maxx,ans);
        dfs(node.left);
        dfs(node.right);
    }

    public int depth(TreeNode node){
        if(node==null) return 0;
        return Math.max(depth(node.left),depth(node.right))+1;
    }
}
