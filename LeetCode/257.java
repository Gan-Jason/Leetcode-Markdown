//本题思路明确，就是前序遍历，把path都保存起来，返回上一层的时候把path的本层节点截掉。实现上由于对String不熟，导致不知道如何实现保存path，先是用list把root.val记录了然后遍历list串联字符串
//导致效率很低，时间花销是o（n*h），
//后来用String去保存path，而且返回上一层的时候String path=path.substring(0,path.length()-3);去截掉后面三个，其实没必要，因为String是不可修改的，传String参数时，相当于传基本数据类型
//是传值，因此返回上一层时自动复原到传入前的状态。



//时间复杂度o（n）
class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return ans;
    }
    public void dfs(TreeNode root,String path){
        if(root==null){   
            return;
        }
        if(root.left==null&&root.right==null){
            path+=root.val;
            ans.add(path);
        }
        else
            path+=root.val+"->";
        dfs(root.left,path);
        dfs(root.right,path);
        
    }
    
}
