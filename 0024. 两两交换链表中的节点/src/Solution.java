class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月06日 13:34
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp =dummy;
        while(temp.next!=null){
            if(temp.next.next==null){
                break;
            }
            ListNode tail=temp.next.next.next;
            temp.next.next.next=temp.next;
            temp.next=temp.next.next;
            temp.next.next.next=tail;
            temp=temp.next.next;
        }
        return dummy.next;
    }
}
