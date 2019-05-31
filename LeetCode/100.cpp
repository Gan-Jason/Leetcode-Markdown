#include<iostream>
#include<cstdlib>
#include<queue>
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
    bool isSameTree(TreeNode* p, TreeNode* q) {
        /*if(!q&&!p) return true;
        else if(!p||!q) return false;
        else
        {
            if(q->val==p->val)
                {
                    return isSameTree(p->left,q->left)&&isSameTree(p->right,q->right);
                }
            else
                return false;
        }*/
        if(!p&&!q) return true;
        else if(!p||!q) return false;
        queue<TreeNode*> qu1;
        queue<TreeNode*>qu2;
        qu1.push(p);
        qu2.push(q);
        TreeNode* temp1,*temp2;
        temp1=qu1.front();
        

    }
};

int main()
{
    TreeNode* p=new TreeNode(1);
    TreeNode* a=new TreeNode(2);
    p->right=a;
    TreeNode* q=new TreeNode(1);
    TreeNode* b=new TreeNode(3);
    q->right=b;
    Solution so;
    cout<<so.isSameTree(p,q)<<endl;
    system("pause");
    return 0;
}