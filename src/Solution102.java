import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            List<Integer> ans = new LinkedList<>();
            int size = que.size();

            for (int i = size; i > 0; i--) {
                // 当前的que中元素是同一层的！
                TreeNode node = que.poll();
                ans.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            lists.add(ans);
        }
        return lists;
    }
}
