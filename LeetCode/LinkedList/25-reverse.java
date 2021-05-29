//反转链表，只要找到子链表的区间即可，一个个子链表区间反转
//我的方法是计算链表长度，用i+k去迭代找区间
//另一个方法是不用知道链表长度，每次找到子区间的pre节点，并保证区间长度为k，翻转k个即可
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head.next==null||k==1){
            return head;
        }
        int len=0;
        ListNode count=head;
        while(count!=null){
            count=count.next;
            len++;
        }
        int t=len%k;
        len=t==0?len:len-t;
        for(int i=1;i+k-1<=len;i=i+k){
            head=reverse(head,i,i+k-1);
        }
        return head;
    }
    private ListNode reverse(ListNode head,int left,int right){
        ListNode fake=new ListNode(-1);
        fake.next=head;
        ListNode cur,next,pre=fake;
        for(int i=1;i<left;i++){
            pre=pre.next;
        }
        cur=pre.next;
        int count=0;
        while(count<right-left){
            next=cur.next;
            cur.next=next.next;
            next.next=pre.next;
            pre.next=next;
            count++;
        }
        return fake.next;

    }
}
