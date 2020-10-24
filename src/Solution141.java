import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head!=null){
           if(s.contains(head)){
                return true;
           }
           s.add(head);
           head = head.next;
        }
        return false;
    }
}
