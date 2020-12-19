import java.util.Stack;

public class Solution206 {
//    public ListNode reverseList(ListNode head) {
//        if(head==null) return null;
//        Stack<ListNode> stack = new Stack<>();
//        while(head!=null){
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode ans = stack.pop();
//        ListNode nowNode = ans;
//        while(!stack.isEmpty()){
//            ListNode t = stack.pop();
//            t.next = null;
//            ans.next = t;
//            ans = t;
//        }
//        return nowNode;
//    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=null,cur=head;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return cur;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution206 s = new Solution206();
        s.reverseList(node1);
    }
}
