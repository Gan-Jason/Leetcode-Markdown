//本题利用bst特性，中序是有序递增/有序递减的，因此从大到小可以把右边大数的结果往回传，并更新节点值
//有序递减的话是从右往左

class Solution {
    private int sum=0;
    
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
    
    void dfs(TreeNode root){      //也可以用一个函数就搞定，就不需要下面的返回值，只需要维护一个累加值即可。
        if(root==null)return;
        dfs(root.right);
        sum+=root.val;
        root.val=sum;
        dfs(root.left);
    }
    
    
}
