//这题没有算法，只是工作量比较大，要注意边界条件，以及各种情况的合并
//我写的比较冗余，因为选择循环的对象选错了，导致要判断的情况比较多
//难点是，不需要固定思维，一定要按照常规的想法去循环，而是选择比较直接/高度概括的条件去循环
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        List<ListNode> ans=new ArrayList<>();
        int len=0;
        ListNode p=root,q=root;
        while(p!=null){
            p=p.next;
            len++;
        }
        int sum=len/k;
        p=root;
        if(sum==0){       我选择了遍历原链表，如果是根据k来循环，sum作为内循环，这几种情况都可以合并
            while(p!=null){
                q=p.next;
                ans.add(p);
                p.next=null;
                p=q;
            }
            for(int i=0;i<k-len;i++){
                ans.add(null);
            }
        }else{
            if(len%k==0){
                while(p!=null){     //没有发现很相似吗，跟下面的一些循环或者操作，一般这种都可以合并的
                    ans.add(p);
                    for(int i=0;i<sum;i++){
                        if(i+1==sum){
                            q=p.next;
                            p.next=null;
                        }else{
                            p=p.next;
                        }
                        
                    }
                    p=q;
                }
            }else{
                int m=len%k;
                while(p!=null){
                    ans.add(p);
                    if(m>0){
                        for(int i=0;i<sum+1;i++){
                            if(i+1==sum+1){
                                q=p.next;
                                p.next=null;
                            }else{
                                p=p.next;
                            }
                        }
                        p=q;
                        m--;
                    }else{
                        for(int i=0;i<sum;i++){
                            if(i+1==sum){
                                q=p.next;
                                p.next=null;
                            }else{
                                p=p.next;
                            }
                        }
                        p=q;
                    }
                }
            }
        }
        // ListNode[] r=new ListNode[ans.size()];
        // for(int i=0;i<ans.size();i++){
        //     r[i]=ans.get(i);
        // }
        return (ListNode[])ans.toArray(new ListNode[0]);
    }
}

