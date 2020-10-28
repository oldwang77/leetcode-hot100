public class Solution437 {
    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root,sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }

    public void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum -= node.val;
        if (sum == 0) {
            ans++;
            // 这里不能加return ;因为等于0后，这条路上可能还有其他情况满足和为0的可能
            // return;
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
