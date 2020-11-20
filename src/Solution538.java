import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution538 {
    int ans = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        // 最右下角的节点的val就是自身
        ans += node.val;
        node.val = ans;
        dfs(node.left);
    }
}


//class Solution {
//    HashMap<TreeNode,Integer> hashMap = new HashMap();
//    ArrayList<TreeNode> list = new ArrayList<>();
//    public TreeNode convertBST(TreeNode root) {
//        if (root==null){
//            return null;
//        }
//        // 各个节点的值不相同
//        dfs(root);
//        // 计算比每个节点大于等于的数值和
//        int ans = 0;
//        for(int i = list.size()-1;i>=0;i--){
//            ans += list.get(i).val;
//            hashMap.put(list.get(i),ans);
//        }
//
//        // 转换为累加树
//        rebuildTree(root);
//        // 进行一个镜像翻转
//        swapTree(root);
//        return root;
//    }
//
//    public void swapTree(TreeNode node){
//        if(node==null){
//            return ;
//        }
//        TreeNode left = node.left;
//        node.left = node.right;
//        node.right = left;
//        swapTree(node.left);
//        swapTree(node.right);
//    }
//
//    public void rebuildTree(TreeNode node){
//        if(node==null){
//            return;
//        }
//        rebuildTree(node.left);
//        node.val = hashMap.get(node);
//        rebuildTree(node.right);
//    }
//
//    public void dfs(TreeNode node){
//        if(node==null){
//            return ;
//        }
//        dfs(node.left);
//        hashMap.put(node,node.val);
//        list.add(node);
//        dfs(node.right);
//    }
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        TreeNode ans1 = new TreeNode(1);
//        TreeNode ans2 = new TreeNode(2);
//        TreeNode ans3 = new TreeNode(3);
//        TreeNode ans4 = new TreeNode(4);
//        ans3.left = ans2;
//        ans2.left = ans1;
//        ans3.right = ans4;
//        s.convertBST(ans3);
//    }
//}