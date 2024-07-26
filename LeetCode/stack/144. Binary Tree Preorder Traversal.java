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
    //非递归前序遍历二叉树
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> qu=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        if(root!=null){
            qu.push(root);
        }
        while(!qu.empty()){
            TreeNode temp=qu.pop();
            ans.add(temp.val);
            if(temp.right!=null)
                qu.push(temp.right);
            if(temp.left!=null)
                qu.push(temp.left);
            
        }
        return ans;
    }
}
