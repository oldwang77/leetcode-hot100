
public class Solution148 {
    // 参考：https://leetcode-cn.com/problems/sort-list/solution/javadi-gui-die-dai-shuang-zhong-jie-fa-luo-ji-qing/
    public ListNode findMid(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        // 用快慢指针找到链表的中点
        ListNode slow = node, fast = node.next;
        while (fast != null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        return ans;
    }

    // merge
    public ListNode merge(ListNode left, ListNode right) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
            } else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }
        p.next = (left == null) ? right : left;
        return ans.next;
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 注意，这里必须先排序右边，因为findMid函数中，会切分链表
        ListNode right = sortList(findMid(head));
        ListNode left = sortList(head);
        return merge(left, right);
    }
}
