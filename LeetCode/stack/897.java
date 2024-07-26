//第一想法是，bst的中序遍历是有序递增的，因此这题与中序有关，一开始我以为是用递归的话有点麻烦，因为要砍掉左子树，所以我就想着用栈来取代递归，在弹出节点时用按新的方式接上
//其实这题也可以用中序递归，访问节点时，直接砍左支接右枝也可以，因为接右枝是上一个接本节点，而不是本节点接下一个，而且左支已经遍历完，这样是不影响后面的遍历的。


class Solution {
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)return null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        TreeNode right=new TreeNode(-1);
        TreeNode ans=right;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;       //先入左的
            }
            if(!stack.isEmpty()){
                TreeNode cur=stack.pop();     //弹出栈节点
                p=cur;            
                right.right=cur;        //用right的树节点接上
                cur.left=null;          //砍掉右枝
                right=right.right;      
                p=p.right;            //p继续遍历原树的右孩子，有的话继续入栈
            }
            
        }
        
        return ans.right;
    }
}


class Solution {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
