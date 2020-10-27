public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        // 根据快慢指针，找到链表的中点
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 翻转链表[slow,end]部分
        reverse(slow);

        // 检查[head,slow)和[slow,end]是不是相同
        while(head!=null && slow!=null){
            if(head.val!=slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        
    }

    public void reverse(ListNode slow) {
        ListNode p = slow, q = slow, pre = null;
        while (q != null) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
    }
}
