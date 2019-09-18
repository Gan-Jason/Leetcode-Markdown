/**
* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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
    private List<List<Integer>> ans=new ArrayList<>();
		//遍历二叉树，返回结点值累加和为sum的路径的结点值的二维数组
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //temp用来储存当前已经遍历的路径结点
        List<Integer> temp=new ArrayList<>();
        calculatePath(root,sum,temp);
        return ans;
    }
    private void calculatePath(TreeNode root,int sum,List<Integer> temp){
        //当前结点为null的递归结束
        if(root==null)
            return;
        //不管是什么值都压进temp数组中
        temp.add(root.val);
        //如果当前结点值是符合要求的话，就把temp压进二维数组中，并且把temp中最后一个值删除，因为Java中的封装的类型是引用类型，直接引用堆上的变量，
        //是不会随着局部函数的结束而释放空间，这点与C++有一点区别
        if(sum-root.val==0&&root.left==null&&root.right==null){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        //若不符合，则递归遍历左右子树
        }else{
            calculatePath(root.left, sum-root.val, temp);
            calculatePath(root.right, sum-root.val, temp);
        }
        //回溯的过程记得擦除temp中最后结点值
        temp.remove(temp.size()-1);
    }
}
