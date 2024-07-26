class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
    //螺旋读取矩阵的数
        vector<int> ans;
        //如果二维数组为零
        if(!matrix.size())
            return ans;
        //R为行数，C为列数
        int R = matrix.size(), C = matrix[0].size();
        //二维数组seen用来存储每一个位置上是否已经遍历过的标记，1为遍历过，0为未遍历
        int seen[R][C]={0};
        //dr为旋转一圈的对于行的行走动作，dc为每旋转一圈对于列的行走动作：0为方向不变，1为向下或者向右的正方向走一步，-1为向上或者向左的负方向走一步
        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        //di为当前的行列行走动作的下标，如di=0时，则行的方向为向右dr[di]=0（当前行），列的方向为向右dc[di]=1(正方向走一步)
        int r=0,c=0,di=0;
        for(int i=0;i<R*C;i++)
        {
            //结果压入结果集中
            ans.push_back(matrix[r][c]);
            //当前位置标记置1
            seen[r][c]=1;
            //下一位置为当前位置+行走动作
            int cr = r + dr[di];
            int cc = c + dc[di];
            //如果下一位置符合要求且未被遍历过，则走下去
            if(cr>=0&&cr<R&&cc>=0&&cc<C&&seen[cr][cc]!=1)
            {
                r=cr;
                c=cc;
            }
            //否则继续走动
            else{
                di=(di+1)%4;
                r+=dr[di];
                c+=dc[di];
            }
        }
        return ans;
        
    }
};
