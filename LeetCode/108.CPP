#include<iostream>
#include<vector>
#include"TreeNode.cpp"
using namespace std;


class Solution
{
public:
    TreeNode *sortedArrayToBST(vector<int> &num)
    {
        if(!num.size()) return NULL;                    //数组为空，递归结束
        if(num.size()==1) return new TreeNode(num[0]);  
        int low=0,high=num.size()-1;                    //二分查找思想 找当前结点
        int mid=(low+high)%2?(low+high)/2+1:(low+high)/2;   //int型的变量会向下取整，对于题目要求的二叉树结构来说，需要调整一下结点结构
        TreeNode* root = new TreeNode(num[mid]);        //构造树节点
        vector<int>left_tree_child(num.begin(),num.begin()+mid);    //左子树的数组
        vector<int>right_tree_child(num.begin()+mid,num.end());     //右子树数组
        root->left=sortedArrayToBST(left_tree_child);    //递归左子树数组
        root->right=sortedArrayToBST(right_tree_child);  //递归右子树数组
        return root;
    }
};

