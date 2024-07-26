/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.*/

#include<iostream>
#include"TreeNode.cpp"

class Solution {
public:
    bool isBalanced(TreeNode* root) {                   //这道题基于计算二叉树高度和平衡二叉树判定
        if(!root) return true;                          //若为空树也是一种平衡树
        int difference = TreeHeight(root->left)-TreeHeight(root->right);    //计算根节点的左右子树的高度
        if(abs(difference)>1)                           //若左右子树的高度差绝对值超过1，则不是平衡树
            return false;                               
        return isBalanced(root->right)&&isBalanced(root->left);     //递归判定根节点的左右子树是否为平衡树
        
        
    }
    int TreeHeight(TreeNode* root)                      //计算二叉树的高度
    {
        if(!root)
            return 0;
        return max(TreeHeight(root->left),TreeHeight(root->right))+1;   //二叉树高度为左右子树中较高的子树的高度值加上1（加上根节点高度）
        //(TreeHeight(root->right)>TreeHeight(root->left)?TreeHeight(root->right):TreeHeight(root->left))+1;
        //一开始我忘了直接用一个max函数即可，而是用了三目运算符，导致summit的时候超时了，我觉得也不至于超时吧，可能数据量大了性能就差了

    }
};
