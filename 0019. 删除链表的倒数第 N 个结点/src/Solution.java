import java.awt.*;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月03日 15:24
 */



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = dummy;
        for(int i=0;i<n;i++){
            first=first.next;
        }
        ListNode second = dummy;
        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return dummy.next;
    }
}
