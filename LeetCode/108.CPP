#include<iostream>
#include<vector>
#include"TreeNode.cpp"
using namespace std;


class Solution
{
public:
    TreeNode *sortedArrayToBST(vector<int> &num)
    {
        if(!num.size()) return NULL;
        if(num.size()==1) return new TreeNode(num[0]);
        int low=0,high=num.size()-1;
        int mid=(low+high)%2?(low+high)/2+1:(low+high)/2;
        TreeNode* root = new TreeNode(num[mid]);
        vector<int>left_tree_child(num.begin(),num.begin()+mid);
        vector<int>right_tree_child(num.begin()+mid,num.end());
        root->left=sortedArrayToBST(left_tree_child);
        root->right=sortedArrayToBST(right_tree_child);
        return root;
    }
};

