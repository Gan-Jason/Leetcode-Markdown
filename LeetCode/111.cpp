/* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the 
root node down to the nearest leaf node.*/


#include"TreeNode.cpp"

class Solution {
public:
    int minDepth(TreeNode* root) {                         //计算二叉树的最小高度
        if(!root)
            return 0;
        if(root->right&&!root->left||root->left&&!root->right)  //若二叉树是单枝树，则计算有枝的子树
        {
            if(root->right&&!root->left)
                return minDepth(root->right)+1;
            else
                return minDepth(root->left)+1;
        }
        return min(minDepth(root->left),minDepth(root->right))+1;   //常规操作，返回左右子树中高度小的子树高度，最后的高度等于子树高度加上根节点高度
    }
};