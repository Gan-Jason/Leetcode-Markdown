//这个算是线索二叉树，把空的指针利用起来，形成一个双向链表。
//本质上是中序遍历，用栈的中序较为直观一点，但是可能性能略差
//用dfs要注意维护一个指针指向左子树的最大值，和右子树的最小值。根结点去把左右指针指向这两个值即可

class Solution {
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
      //用栈进行中序遍历
//         Deque<Node> stack=new ArrayDeque<>();
//         Node ans=null,last=null,p=root;
//         while(!stack.isEmpty()||p!=null){
//             while(p!=null){
//                 stack.push(p);
//                 p=p.left;
//             }
//             if(!stack.isEmpty()){
//                 p=stack.pop();
//                 if(ans==null){
//                     ans=p;
//                     last=ans;
//                 }else{
//                     last.right=p;
//                     p.left=last;
//                     last=last.right;
//                 }
//                 if(p.right==null&&stack.isEmpty()){
//                     break;
//                 }
//                 p=p.right;
//             }
//         }
//         ans.left=p;
//         p.right=ans;
//         return ans;
        // dfs(root);
        // while(root.left!=null){
        //     root=root.left;
        // }
        // root.left=last;
        // last.right=root;
        // return root;
    }
    Node last=null;
    private void dfs(Node root){
        if(root==null){
            return;
        }
        Node cur=root;    //保存当前的根结点
        dfs(root.left);
        if(last!=null)
            cur.left=last;    //此时的cur可能是右子树的第一个节点，也可以是根结点，
        if(last!=null)
            last.right=cur;   //
        last=cur;     //此时是做子树的最后一个节点，
        dfs(root.right);
    }

}
