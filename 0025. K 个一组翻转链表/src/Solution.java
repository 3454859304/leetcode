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
 * @date: 2022年08月06日 14:53
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp =dummy;
        ListNode kEnd = temp;
        boolean flag=false;
        while(true){
            for(int i=0;i<k;i++){
                if(kEnd==null){
                    flag=true;
                    break;
                }
                else kEnd=kEnd.next;
            }
            if(flag||kEnd==null) break;
            kEnd=temp.next;
            for(int i=1;i<k;i++){
                ListNode kStart=temp.next;
                ListNode kNewStart=kEnd.next;
                //换顺序
                temp.next=kNewStart;
                kEnd.next=kNewStart.next;
                kNewStart.next=kStart;
            }
            temp=kEnd;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        Solution solution = new Solution();
        solution.reverseKGroup(listNode1,2);
    }
}
