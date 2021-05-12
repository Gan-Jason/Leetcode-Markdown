//本题思路明确，既可以top down（第一反应），也可以bottom up，bu难想一点，bu要建立当前状态的答案，并利用子问题提供的答案，最后一起返回。


class Solution {
    private int num=0;
    public int goodNodes(TreeNode root) {
        dfs(root,-10000);
        return num;
    }
    
    private void dfs(TreeNode root,int max){      //top down 须要传状态答案下去，给子节点调用
        if(root==null)return;
        if(root.val>=max){        //计算答案
            num+=1;     
        }
        max=Math.max(root.val,max);   //建立当前的状态
        dfs(root.left,max); //当前状态传下去
        dfs(root.right,max);
    }
    
}


class solution{
    public int goodNodes(TreeNode root) {
        dfs(root,-10000);
        return num;
    }
    private int dfs(TreeNode root,int max){
        if(root==null)return;
        int num=0;
        if(root.val>=max){        //计算答案
            num+=1;     
        }
        max=Math.max(root.val,max);   //建立当前的状态
        num+=dfs(root.left,max);      //并利用子问题传回来的答案
        num+=dfs(root.right,max);
        return num;
      
    }
  
}



