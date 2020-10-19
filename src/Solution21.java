public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode t = node;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                node.next = l1;
                node = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            node.next = l1;
        }
        if(l2!=null){
            node.next = l2;
        }
        return t.next;
    }
}
