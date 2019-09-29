/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 *
 *
 */
 
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class Solution {
    private List<Integer> ans=new ArrayList<>();
    //非递归后序遍历二叉树，我用的是双栈法
    //用两个栈，一个用来接收结果，一个作为暂时的中转站，中转站弹出一个结点，该结点如果有左右结点，则左节点先入中转栈，右节点后入中转栈；弹出的结点压进
    //结果栈，最后结果栈全部出栈即可
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)return ans;
        Stack<TreeNode> sta1=new Stack<>();
        Stack<TreeNode> sta2=new Stack<>();
        sta1.push(root);
        while(!sta1.isEmpty()){
            TreeNode temp=sta1.pop();
            if(temp.left!=null){
                sta1.push(temp.left);
            }
            if(temp.right!=null){
                sta1.push(temp.right);
            }
            sta2.push(temp);
        }
        while(!sta2.isEmpty()){
            ans.add(sta2.pop().val);
        }
        return ans;
    }

}
