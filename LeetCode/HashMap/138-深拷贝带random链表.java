//这题可以只用一个map，保存久节点和新节点，第一次遍历先构造新节点并和旧节点存放入map中，第二次遍历更新next和random
//两个map道理也是一样，只是我用map存放下标和节点，下标多余了
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node p=head;
        Node nHead=new Node(p.val);
        Node q=nHead;
        int i=0;
        //这里的两个map其实可以合并，
        Map<Node,Integer> index=new HashMap<>(1000);
        Map<Integer,Node> nIndex=new HashMap<>(1000);
        while(p!=null){
            if(p.next!=null)
                q.next=new Node(p.next.val);
            index.put(p,i);
            nIndex.put(i,q);
            p=p.next;
            q=q.next;
            i++;
        }
        p=head;
        q=nHead;
        while(p!=null){
            int pos=index.getOrDefault(p.random,-1).intValue();
            q.random=nIndex.get(pos);
            p=p.next;
            q=q.next;
        }
        return nHead;
    }
}
