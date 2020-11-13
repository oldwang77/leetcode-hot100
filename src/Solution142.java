import java.util.HashMap;
import java.util.LinkedList;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast = head, slow = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
        } while (fast != slow);
        // 当slow和fast第一次相遇后
        // fast走的步数是slow的两倍
        // f = 2s,f = s+nb
        // 此时让快指针从头节点开始走，再次和慢结点相遇时，就是环的入口
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    // public ListNode detectCycle(ListNode head) {
    //     LinkedList<ListNode> lst = new LinkedList<>();
    //     ListNode tmp = head;
    //     if (head == null) return null;
    //     while (head != null) {
    //         lst.add(head);
    //         if (head.next == null) {
    //             return null;
    //         }
    //         head = head.next;
    //         if (lst.contains(head)) {
    //             tmp = head;
    //             break;
    //         }
    //     }
    //     return tmp;
    // }
}
