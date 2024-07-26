/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
        Node p;
        if(root==null)
            return root;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            if(size==1){
                p=queue.remove();
                if(p.left!=null){
                    queue.add(p.left);
                }
                if(p.right!=null)
                    queue.add(p.right);
                continue;
            }
            for(int i=0;i<size;i++){
                p=queue.remove();
                if(i!=size-1){
                    p.next=queue.element();
                }
                if(p.left!=null){
                    queue.add(p.left);
                }
                if(p.right!=null)
                    queue.add(p.right);
            }
        }
        return root;
    }
}
