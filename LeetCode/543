/*
* Given the root of a binary tree, return the length of the diameter of the tree.

* The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

* The length of a path between two nodes is represented by the number of edges between them.
*/

/*
* 本题的思路是，根结点没有左右子节点时，最长路径就是0；有左右子树时，最长直径=max（所有节点的最长直径），
* 仔细观察就知道树的最长直径就是左右子树的层数相加，所以每次计算节点的直径时都记录并且比较出最大值。
*/

class Solution {
    private int max=0;
       
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        levelCount(root);
        
        
        return max;
    }
    
    public int levelCount(TreeNode root){
        if(root==null){
            return 0;
        }
        int lLevel=levelCount(root.left);
        int rLevel=levelCount(root.right);
        max=Math.max(max,lLevel+rLevel);
        return lLevel>rLevel?lLevel+1:rLevel+1;
        
    }
}
