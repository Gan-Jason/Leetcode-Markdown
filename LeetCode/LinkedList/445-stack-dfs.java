//这题按常规的加法就是从低位算起，
//1.dfs，用bottom up的话，要求两个链表具有一样的长度，然后子问题返回相加后是否进位的答案，当前状态为当前的两个链表节点相加再加上子问题返回的进位值，这种dfs需要补齐较短的链表长度，可以在高位补0，
//这里要注意一个问题，就是递归回到头节点的时候，要注意第一次调用递归的地方也要判断一下返回值，即有无进位，如果有进位还需要新增一个头节点作为最高位
//2. stack，吧两个链表入栈，出栈的时候就是低位先出，


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode p=l1;
        int m=0,n=0;
        while(p!=null){
            p=p.next;
            m++;
        }
        p=l2;
        while(p!=null){
            p=p.next;
            n++;
        }
        if(m>n){
            for(int i=0;i<m-n;i++){
                ListNode t=new ListNode(0);
                t.next=l2;
                l2=t;
            }
        }else{
            for(int i=0;i<n-m;i++){
                ListNode t=new ListNode(0);
                t.next=l1;
                l1=t;
            }
        }
        if(dfs(l1,l2)==1){
            ListNode t=new ListNode(1);
            t.next=l1;
            l1=t;
        }
        return l1;
    }
    private int dfs(ListNode l1,ListNode l2){
        if(l1==null){
            return 0;
        }
        int plus=dfs(l1.next,l2.next);
        int sum=(l1.val+l2.val+plus);
        l1.val=sum%10;
        return sum>9?1:0;
    }
}
