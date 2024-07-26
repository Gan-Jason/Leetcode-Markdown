//这题没读清楚题目的情况下，先是用了暴力解：中序得到错误的BST序列，再排序，再重新中序遍历，把排好序的值赋给BST
//再重新看了一下题目，发现只有两个节点是错乱的，于是想到，中序遍历下保存中序序列，找到当前节点比前一个大的位置，把前一个大的记录下来记为A，再找到第二个错乱的B，最后把A、B交换即可。
//这个思路是对的，但是实现的时候我就只想到了记录错误的值A、B，然后再重新遍历一次把A、B交换，这样还是不够清晰
//其实只需要把A、B节点记下来记为全局变量，中序遍历完后，用全局变量的引用去交换即可

public class Solution {
    
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement ;  //这里就不用初始化了，因为题目的限制改为节点值可以是int的最小值，即-2147483648，因此
    int flag=0;             //用一个标记位去标识第一个节点即可
    public void recoverTree(TreeNode root) {
        
        // In order traversal to find the two elements
        traverse(root);
        
        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null)
            return;
            
        traverse(root.left);
        
        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (flag!=0&&firstElement == null && prevElement.val >= root.val) {   //不是第一个节点才比较。
            firstElement = prevElement;
        }
    
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (flag!=0&&firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;
        flag=1;     //第一个节点遍历后，标记位置为
        // End of "do some business"

        traverse(root.right);
}
}
