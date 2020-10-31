public class Solution337 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        return findMax(root);
    }

    public int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 这个点取的话
        int ans = 0;
        if (node.left != null) {
            ans += findMax(node.left.left) + findMax(node.left.right);
        }
        if (node.right != null) {
            ans += findMax(node.right.right) + findMax(node.right.left);
        }
        ans += node.val;

        // 这个点不取的话
        int ans2 = findMax(node.left) + findMax(node.right);

        return Math.max(ans, ans2);
    }
}
