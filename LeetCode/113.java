// 1. dfs，跟计算最大路径值的思路相似，top down，并且把路径也传下去。一开始思路是没问题，问题出在了实现上，java除了基本类型外其他大部分是引用，因此传下去的list路径会一直保存历史路径
// 导致叶子节点遍历完后还在path里，从而影响右子树的遍历，一开始想着深拷贝然后清空path，但是把root也清空了。在这里想了很久。
// 最后看讨论区发现，实现都是把每个节点都保存了，当一个节点左右子树遍历完后就删掉path最后一个节点，效果相当于传变量是个临时变量，回到上一层就没了下一层的节点

class Solution {
    private List<List<Integer>> anser=new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null)return anser;
        List<Integer> path=new ArrayList<Integer>();
        getPath(root,0,path,targetSum);
        return anser;
    }
    
    public void getPath(TreeNode root,int sum,List<Integer> path,int targetSum){
        if(root==null)return;
        sum+=root.val;

        path.add(root.val);       //每个节点都可以放进去，一开始我这里做了判断，sum>target时候就return，但是出现负数的时候这个判断就有问题了，负数会大于taget
        if(root.left==null&&root.right==null){
            if(sum==targetSum)
            {
                anser.add(new ArrayList(path));
                path.remove(path.size()-1);     //走到叶子节点也删除队尾
                return;
            }
        }
        getPath(root.left,sum,path,targetSum);
        getPath(root.right,sum,path,targetSum);
        path.remove(path.size()-1);       //删除本层节点，这里效果相当于删除下一层的节点，

        
    }
}
