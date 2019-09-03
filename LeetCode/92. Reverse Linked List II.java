/*
* Reverse a linked list from position m to n. Do it in one-pass.
*
* Note: 1 ≤ m ≤ n ≤ length of list.
**/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return head;
        ListNode cur,pre,then;
        pre=new ListNode(-1);
        pre.next=head;
        int count=0;
        //找到pre节点，也就是第m个的前一个，pre不变
        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        for(int i=1;i<m;i++){
            pre=pre.next;
        }
        cur也不变，变的是then
        cur=pre.next;
        then=cur.next;
    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        while(count<n-m){
            cur.next=then.next;
            then.next=pre.next;
            pre.next=then;
            then=cur.next;
            count++;
        }
        if(m==1)
            return pre.next;
        return head;
    }
}
