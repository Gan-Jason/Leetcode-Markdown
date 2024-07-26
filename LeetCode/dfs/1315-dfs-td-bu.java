//本题很简单的思路就是top down，判断root的奇偶，再判断孙子，是否可以累加（不为null）
//也可以用bottom up，那就需要知道grandparent和parent，而下一层的grandparent就是本层的parent，下一层的parent就是本层，因此可以传值下去，用来计算是否为偶数

class Solution {
    private int ans=0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)return 0;
        if(root.val%2==0){    //我的方法，比较中规中矩，也比较清晰，就是长了一点
        if(root.left!=null){
            if(root.left.left!=null){
                ans+=root.left.left.val;
            }
            if(root.left.right!=null){
                ans+=root.left.right.val;
            }
        }
        if(root.right!=null){
            if(root.right.left!=null){
                ans+=root.right.left.val;
            }
            if(root.right.right!=null){
                ans+=root.right.right.val;
            }
        }
        }
        sumEvenGrandparent(root.left);
        sumEvenGrandparent(root.right);
        return ans;
    }
}

class Solution{
 private int ans=0;
      public int sumEvenGrandparent(TreeNode root) {
        dfs(root,1,1);          //这里初始化了一个开始的值，用于串起后面的递归，
        return ans;
        
      }
  
  void dfs(TreeNode root,int gp,int p){
    if(root==null)return;
    if(gp%2==0){
      
      ans+=root.val;
    }
    dfs(root.left,p,root.val);    //本层就是下层的parent，本层的p就是下层的gp
    dfs(root.right,p,root.val);
    
    
    
  }

  
}
