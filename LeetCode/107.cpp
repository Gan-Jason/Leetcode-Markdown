/*107.Given a binary tree, return the bottom-up level order traversal of its nodes' values. /
(ie, from left to right, level by level from leaf to root).*/

#include<cstdlib>
#include<vector>
#include<queue>
#include"CreateTree.cpp"
using namespace std;

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        //BFS,广度优先层次遍历二叉树
        vector<vector<int> >leveltra;       //存放结果的二维数组
        vector<int> temp;                   //存放当前层遍历结果的数组
        if(!root) return leveltra;
        queue<TreeNode* >qu;                //层次遍历的队列
        //TreeNode* p=NULL;
        qu.push(root);
        // qu.push(NULL);
        while(!qu.empty())                  //队列非空时循环遍历树节点
        {
            int levelNodeNum=qu.size();     //当前层结点数等于队列节点数，解决问题最关键的一点
            temp.clear();                   
            for(int i=0;i<levelNodeNum;i++) //循环遍历当前层结点，有左右孩子的结点的话孩子入队
            {
                if(qu.front()->left)        
                    qu.push(qu.front()->left);
                if(qu.front()->right)
                    qu.push(qu.front()->right);
                temp.push_back(qu.front()->val);    //当前层结点入临时层数组
                qu.pop();
            }
            leveltra.insert(leveltra.begin(),temp); //层数组入结果数组
        }
        return leveltra;
    }   
};

int main()
{
    TreeNode* root=new TreeNode(1);
    TreeNode* p=new TreeNode(2);
    //TreeNode* q=new TreeNode(20);
    root->left=p;
   /* root->right=q;
    p=root->right;
    TreeNode* a=new TreeNode(15);
    p->left=a;
    TreeNode* b=new TreeNode(7);
    p->right=b;*/
    Solution so;
    vector<vector<int> >result=so.levelOrderBottom(root);
    for(int i=0;i<result.size();i++)
    {
        for(int j=0;j<result[i].size();j++)
            cout<<result[i][j]<<" ";
        cout<<endl;
    }
    system("pause");
    return 0;
}
