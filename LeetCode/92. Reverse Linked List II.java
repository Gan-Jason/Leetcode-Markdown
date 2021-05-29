//这题反转链表升级，只需要找到left，pre为left前节点，反转left到right即可
//思路清晰的做法就是，找到pre，left，right，end(right下一个)，把left到right从原链表中切断出来，反转left，再接回去
//其他方法就是找到pre，头插法反转left到right，循环条件时反转的节点数为right-left


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //1. 复杂度为2n
        if(head.next==null||left==right){
            return head;
        }
        ListNode fake=new ListNode(-1),rNode=fake,pre=fake;
        fake.next=head;
        for(int i=1;i<left;i++){
            pre=pre.next;
        }
        // for(int j=1;j<=right;j++){
        //     rNode=rNode.next;
        // }
        // ListNode lNode=pre.next,end=rNode.next;
        // rNode.next=null;
        // pre.next=null;
        // ListNode ans=reverseList(lNode);
        // pre.next=ans;
        // lNode.next=end;
        // if(1==left){
        //     return pre.next;
        // }
        // return head;
        //2. 头插法
        ListNode cur=pre.next,next;
        for(int i=0;i<right-left;i++){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return fake.next;
        
    }
    // private ListNode reverseList(ListNode head) {
    //     if(head==null||head.next==null){
    //         return head;
    //     }
    //     ListNode pre=head,p=head.next,q=p.next;
    //     head.next=null;
    //     while(q!=null){
    //         p.next=pre;
    //         pre=p;
    //         p=q;
    //         q=q.next;
    //     }
    //     p.next=pre;
    //     return p;
    // }
}

//下面是第一次做的答案
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
