public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 快慢指针
        ListNode l1, l2;

        l1 = headA;
        l2 = headB;

        // 如果两个链表没有交点，那么l1，l2循环后会同时为null，退出循环
        while (l1 != l2) {
            if (l1 == null) {
                l1 = headB;
            } else {
                l1 = l1.next;
            }
            if (l2 == null) {
                l2 = headA;
            } else {
                l2 = l2.next;
            }
        }
        return l1;
    }
}
