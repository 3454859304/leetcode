class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


/**
 * 功能描述
 * 两数相加
 * @author: PJY
 * @date: 2022年07月09日 15:37
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res= new ListNode(0);
        ListNode temp=res;
        int flag=0;
        while(l1!=null||l2!=null||flag!=0){
            if(l1!=null){
                flag +=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                flag +=l2.val;
                l2=l2.next;
            }
            temp.next=new ListNode(flag%10);
            flag/=10;
            temp=temp.next;
        }
        return res.next;
    }



    public static void main(String[] args) {
        Solution s=new Solution();
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode res=s.addTwoNumbers(l1,l2);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}

