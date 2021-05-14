//本题没做出来，主要是想不到如何找到公共节点
//解题思路是后序遍历，bootom up，向子问题要答案，如果LH==RH且==maxDepth，则该root就是最低公共祖先，子问题传回来的左右子树的叶子节点深度作为子状态答案，再做一个额外的操作，判断是否左右相等
//且等于最大深度

class Solution {
    private TreeNode ans;
    private int maxDepth=0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    public int dfs(TreeNode root,int depth){
        maxDepth=Math.max(maxDepth,depth);
        if(root==null){
            return depth;
        }        
        int L=dfs(root.left,depth+1);
        int R=dfs(root.right,depth+1);
        if(L==maxDepth&&maxDepth==R){
            ans=root;
        }
        return Math.max(L,R);
        
        
    }
    
}
