#include<iostream>
#include"TreeNode.cpp"

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(!root) return true;
        int difference = TreeHeight(root->left)-TreeHeight(root->right);
        if(abs(difference)>1)
            return false;
        return isBalanced(root->right)&&isBalanced(root->left);
        
        
    }
    int TreeHeight(TreeNode* root)
    {
        if(!root)
            return 0;
        return max(TreeHeight(root->left),TreeHeight(root->right))+1;
        //(TreeHeight(root->right)>TreeHeight(root->left)?TreeHeight(root->right):TreeHeight(root->left))+1;

    }
};