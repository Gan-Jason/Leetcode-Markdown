/**
* Given a binary tree, flatten it to a linked list in-place.
*
* For example, given the following tree
*    1
*   / \
*  2   5
* / \   \
*3   4   6
* The flattened tree should look like:
*1
* \
*  2
*   \
*    3
*     \
*      4
*       \
*        5
*         \
*          6
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
    //用来指向遍历结果的临时树根节点
    TreeNode temp_root=new TreeNode(-1);
    TreeNode p=temp_root;
    //遍历二叉树，把二叉树的枝压平，也就是二叉树的前序遍历结果全部接在右子树上
    //直接前序遍历二叉树，把结果保存下来，最后root指向它即可
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        preTraverse(root);
        //清空root的两枝
        root.left=null;
        root.right=null;
        p=root;
        //往右移一位
        temp_root=temp_root.right;
        if(temp_root!=null){
            root.right=temp_root.right;
        }
    }
    //前序遍历二叉树
    private void preTraverse(TreeNode root){
        if(root!=null){
            p.right=new TreeNode(root.val);
            p=p.right;
            preTraverse(root.left);
            preTraverse(root.right);
        }
    }
}
