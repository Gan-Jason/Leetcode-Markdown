#include<iostream>
#include<queue>
#include<cstdlib>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x):val(x),left(NULL),right(NULL){}
};
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        queue<TreeNode* >qu;
        qu.push(root);
        qu.push(root);
        TreeNode* q,*p;
        while(!qu.empty())
        {
            q=qu.front();
            p=qu.front();
            qu.pop();
            qu.pop();
            if(!p&&!q) continue;
            if(!p||!q) return false;
            if(p->val!=q->val) return false;
            qu.push(q->left);
            qu.push(p->right);
            qu.push(q->right);
            qu.push(p->left);
        }
        return true;
    }
};


int main()
{
    TreeNode* root=new TreeNode(1);
    root->left=new TreeNode(2);
    root->right=new TreeNode(2);
    root->left->right=new TreeNode(3);
    root->right->right=new TreeNode(3);
    Solution so;
    cout<<so.isSymmetric(root)<<endl;
    system("pause");


}