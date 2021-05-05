//1. dfs,这题是二叉排序树的例题，删除BST一个节点分三个情况：1. 该节点没有左右子树 ：直接删除
// 2. 该节点只有左子树或者右子树 3. 该节点有左右子树 ：把左子树/右子树挂在parent的本位置上，即用左子树/右子树取代自己
//3. 有两个路径，要么找左子树的最大值来取缔自己，要么找右子树的最小值取缔自己。左子树的最大值：向左走一步，然后一直向右走到尽头的非空节点d，用d的值取代root，删除d，此时的删除d适用1/2情况 
// 本题难点1，如何构造递归，如何分递归函数和主函数。BST有序的，因此子状态就是判断root的val是否和key相等，然后递归左右子树去找到节点并删除
// 难点2，Java的值传递如何修改引用的存储值，即参数传进去只是一个引用的拷贝，在函数里传进来的引用变量和原来对象的引用变量是两个变量，当前引用变量本身改变时并不影响原引用变量的对象发生变化
// 如，p=new P(1);fun(P p){p=new P(0);} //原来的p还是P(1)而不是P(0),因为在fun里，fun栈中的p指向了P(0)，与原来栈中的P(1)没有关系。
//本方法只遍历了一次树的h数量的节点，因此时间复杂度是O(h)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val==key){
            root=delete(root);
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key);    //如果本题只是调用deleteNode(root.right,key); 不会改变root的指向的对象，只有对引用变量进行赋值才能发生改变，因为这样
        }else{                                        //当前引用还是原函数的地址，可以通过原地址去修改原对象
            root.left=deleteNode(root.left,key);
        }
        return root;
        
}
    
    public TreeNode delete(TreeNode root){
        if(root.right==null){
            root=root.left;
        }
        else if(root.left==null){
            root=root.right;
        }
        else{
            TreeNode p=root.left;
            TreeNode f=root;
            while(p.right!=null){
                f=p;
                p=p.right;
            }
            root.val=p.val;
            if(f!=root)f.right=p.left;
            else f.left=p.left;
            
        }
        return root;
    }
}
