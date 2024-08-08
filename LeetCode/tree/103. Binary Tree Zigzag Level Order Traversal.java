/** Given a binary tree, return the zigzag level order traversal of its nodes' values.
  * (ie, from left to right, then right to left for the next level and alternate between).
  * 
  * Given binary tree [3,9,20,null,null,15,7],
  *
  *     3
  *    / \
  *   9  20
  *     /  \
  *    15   7
  * return its zigzag level order traversal as:
  * [
  *   [3],
  *   [20,9],
  *   [15,7]
  * ]
  *
  *
  *
  *
 **/



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
    //之字形遍历二叉树，就是层次遍历，单数层从左到右，偶数层从右到左
    //这样的话可以用两个队列层次遍历二叉树，一个队列是从左往右的顺序，另一个是从右往左的顺序，单数层遍历时把第一个队列的结果压进数组，偶数层时把第二个
    //队列的结果压进数组
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> qu_even=new LinkedList<>();
        Queue<TreeNode> qu_odd=new LinkedList<>();
        TreeNode p=null,q=null;
        //奇偶两个对了
        qu_even.add(root);
        qu_odd.add(root);
        //记录当前层号
        int level=1;
        //由于两个队列都是同样的节点，只是顺序不同，故只用判断其中一个是否为空服
        while(!qu_even.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int num=qu_even.size();
            //判断层数奇偶性
            if(level%2!=0){
                //一层层遍历，num标记了当前层的结点数
                for(int i=0;i<num;i++){
                    p=qu_even.remove();
                    q=qu_odd.remove();
                    if(q.left!=null)
                        qu_odd.add(q.left);
                    if(q.right!=null)
                        qu_odd.add(q.right);
                    if(p.right!=null)
                        qu_even.add(p.right);
                    if(p.left!=null)
                        qu_even.add(p.left);
                    //单数层就把单数层的队列结果压进数组
                    temp.add(q.val);
                }
            }
            else{
                for(int i=0;i<num;i++){
                    p=qu_even.remove();
                    q=qu_odd.remove();
                    if(q.left!=null)
                        qu_odd.add(q.left);
                    if(q.right!=null)
                        qu_odd.add(q.right);
                    if(p.right!=null)
                        qu_even.add(p.right);
                    if(p.left!=null)
                        qu_even.add(p.left);
                    temp.add(p.val);
                }
            }
            level++;
            ans.add(temp);

        }
        return ans;

    }
    }

    // 2024.7.29答案

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode[] queue = new TreeNode[2050];
        int head = 0, tail = 0;
        queue[tail++] = root;
        int level = 0;
        while (head < tail) {
            List<Integer> tmpList = new ArrayList<>();
            int end = tail;// 注意逐层遍历时，遍历条件的右边界不要移动
            while (head < end) {
                TreeNode p = queue[head++]; // 层次遍历，出队一个节点
                if (p != null) { // 根据层的单双决定顺序
                    if (level % 2 == 0) {
                        tmpList.add(p.val);
                    } else {
                        tmpList.add(0, p.val);
                    }
                    // 该节点的子节点入队
                    queue[tail++] = p.left;
                    queue[tail++] = p.right;
                }
            }
            if (!tmpList.isEmpty()) {
                ans.add(tmpList);
            }
            level++;
        }
        return ans;
    }
}