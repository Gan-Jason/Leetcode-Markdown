//简单的dfs，有多种思路，这类型的题，要思路清晰，不要左顾右盼，东想西想。
//一开始我是用中序遍历，然后遍历中序数组，但是性能很低，利用了bst但是多次遍历
//第二次我是直接前序遍历整棵树，与BST特性无关，性能也低
//最后看了别人的答案，利用BST特性，如果root<low,则递归右边，否则递归左边，最后是root+左+右的值


class Solution {
    private List<Integer> path=new ArrayList<>();
    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        getSum(root,high,low);
        return sum;

    }
    
    
    public void inorder(TreeNode root){   //中序遍历得到有序数组
        if(root==null)return;
        if(root.left!=null){
            inorder(root.left);
        }
        path.add(root.val);
        inorder(root.right);
        
    }
    
    
    public void getSum(TreeNode root,int high,int low){   //遍历整棵树
        if(root==null)return;
        if(root.val>=low&&root.val<=high){
            sum+=root.val;
        }
            getSum(root.left,high,low);
            getSum(root.right,high,low);
    }
    
}





class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;
        if(root.val<low)
            return rangeSumBST(root.right,low,high);
        else if(root.val>high)
            return rangeSumBST(root.left,low,high);
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);

    }
    
    

    
    

    
}
