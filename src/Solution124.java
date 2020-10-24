public class Solution124 {
    int maxx = Integer.MIN_VALUE;   //学习了如何表示maxx
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return maxx;
    }

    public int dfs(TreeNode node){
        if(node == null) {
            return 0;
        }
        dfs(node.left);
        dfs(node.right);
        if(node.left==null){
            node.left = new TreeNode(0);
        }
        if(node.right==null){
            node.right = new TreeNode(0);
        }
        int max1 = node.val;
        int max2 = node.val + node.left.val;
        int max3 = node.val + node.right.val;
        int max4 = node.val + node.left.val + node.right.val;

        int ans = Math.max(max3,Math.max(max1,max2));
        int ans2 = Math.max(ans,max4);
        node.val = ans;

        // 记录所有结点的最大值
        maxx = Math.max(maxx,ans2);
        return node.val;
    }
}
