import java.util.LinkedList;
import java.util.List;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        TreeNode ans = null;
        LinkedList<TreeNode> lst = new LinkedList<>();
        LinkedList<TreeNode> lst2 = new LinkedList<>();

        path1 = findPath(root, p, path1, lst);
        path2 = findPath(root, q, path2, lst2);

        int i = 0, j = 0;
        TreeNode tmp = null;
        while (i < path1.size() && j < path2.size()) {
            if (path1.get(i) == path2.get(i)) {
                tmp = path1.get(i);
                i++;
                j++;
            } else {
                break;
            }
        }
        return tmp;
    }

    public LinkedList<TreeNode> findPath(TreeNode node, TreeNode target, LinkedList<TreeNode> path, LinkedList<TreeNode> ans) {
        if (node == null) return null;
        if (node == target) {
            path.add(node);
            ans.clear();
            for (TreeNode tmp : path) {
                ans.add(tmp);
            }
            return path;
        }
        path.add(node);
        findPath(node.left, target, path, ans);
        findPath(node.right, target, path, ans);
        path.removeLast();
        return ans;
    }

    public static void main(String[] args) {
        Solution236 s = new Solution236();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        s.lowestCommonAncestor(node1, node2, node4);
    }
}
