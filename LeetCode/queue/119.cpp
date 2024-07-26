/*Given a non-negative index k where k ≤ 33, 
return the kth index row of the Pascal's triangle. 
Note that the row index starts from 0*/

#include<vector>
#include<queue>
using namespace std;
class Solution {
public:
    vector<int> getRow(int rowIndex) {      //只返回第rowIndex行的杨辉三角，故可用队列来求
        queue<int> qu;
        vector<int> row;
        row.push_back(1);
        if(!rowIndex)
            return row;
        row.push_back(1);
        if(rowIndex==1)
            return row;
        row.clear();
        qu.push(0);
        qu.push(1);
        qu.push(1);
        qu.push(0);
        int q,p,index=2;                //index记为当前行数
        for(int i=2;i<=rowIndex;i++)
        {
            do
            {
                q=qu.front();
                qu.pop();
                p=qu.front();
                qu.push(p+q);           //队列中只保存当前行的元素和两个作为标记一行的0，故额外的空间是k+2，就是O(K)
                if(index==rowIndex)     //当index等于所求行数时才压进数组
                {
                    row.push_back(q+p);
                }
            }while(p);
            qu.push(0);
            index++;
        }
        return row;
    }
};