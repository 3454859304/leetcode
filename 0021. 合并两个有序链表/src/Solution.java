/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月04日 15:14
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0,list1);
        list1=dummy;
        while(list2!=null){
            if(list1.next==null){
                list1.next=list2;
                break;
            }
            else if(list1.next.val>list2.val){
                ListNode tail=list1.next;
                list1.next=list2;
                list2=list2.next;
                list1.next.next=tail;
            }else {
                list1=list1.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(4, null);
        ListNode temp =listNode2;
        listNode4.next=temp;
        temp=listNode1;
        System.out.println(listNode4.next.val);


    }
}
