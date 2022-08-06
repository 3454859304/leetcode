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
 * @date: 2022年08月05日 17:22
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0, null);
        ListNode temp=head;
        while(true){
            ListNode min=null;
            int flag=-1;
            for(int i=0;i<lists.length;i++){
                if(lists[i]==null){
                    continue;
                }
                if(min==null){
                    min=lists[i];
                    flag=i;
                }else if(lists[i].val<min.val){
                    min=lists[i];
                    flag=i;
                }
            }
            if(min==null){
                return head.next;
            }
            temp.next=min;
            temp=min;
            lists[flag]=lists[flag].next;
        }
    }

}
