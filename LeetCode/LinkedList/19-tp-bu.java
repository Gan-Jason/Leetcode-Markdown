//删除链表第k/倒数第k节点，一种是双指针法，一种是递归bottom up
//1. 双指针法就是两个指针相隔k-1，快指针走到表尾部时，慢指针的位置就是答案
//快慢指针求中间节点的话，快指针两步，慢指针走一步。快指针走的路长是慢的两倍
//2. dfs的话，递归到表尾，回溯时用计数器累加节点数，当count==n时，该节点就是答案


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre=new ListNode(-1);
        ListNode p=head,q=head,fake=pre;
        pre.next=head;
	//1. two pointers
        // while(n---1>0){
        //     q=q.next;
        // }
        // while(q.next!=null){
        //     p=p.next;
        //     q=q.next;
        //     pre=pre.next;
        // }
        // pre.next=p.next;
        // head=fake.next;
        // fake=null;
        // return head;
	//2. dfs
        getK(pre,n);
        ans.next=ans.next.next;
        return fake.next;
    }
    private int k=0;
    private ListNode ans;
    void getK(ListNode head,int n){
        if(head==null){
            return;
        }
        getK(head.next,n);
        if(++k==n+1){
            ans=head;
        }
    }

}
