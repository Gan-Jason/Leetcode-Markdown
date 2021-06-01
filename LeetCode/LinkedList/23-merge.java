//1.尾插法，因为链表都是有序的，所以只要把第一个看作是排好序的，后面的都和第一个进行merge就行了
//2. 归并排序，原链表都是有序，因此符合归并条件，把链表数组两两归并，最后[0,mid]和(mid,length)都是有序的，merge这两个即可，这里用到了分治的思想

//我的第一做法
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode head=lists[0],fake=new ListNode(0);
        fake.next=head;
        for(int i=1;i<lists.length;i++){
            ListNode p=fake.next;
            ListNode tail=fake;
            ListNode q=lists[i];
            while(p!=null&&q!=null){
                if(p.val>q.val){
                    tail.next=q;
                    q=q.next;
                }else{
                    tail.next=p;
                    p=p.next;
                }
                tail=tail.next;
            }
            if(p!=null){
                tail.next=p;
            }
            if(q!=null){  //这里判断多余了
                tail.next=q;
            }
        }
        return fake.next;
    }
}
