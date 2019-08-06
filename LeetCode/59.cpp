/*
59. Spiral Matrix II
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
*/

class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
    
    //螺旋构造矩阵，这个和螺旋读取矩阵是一个原理，都是模拟螺旋走法
        //先初始化一个全是0的矩阵，再螺旋走位进行修改每一个值
        vector<vector<int> > ans(n,vector<int>(n));     
        vector<vector<int> >seen(n,vector<int>(n));
        if(n<=0)
            return ans;
        //初始化螺旋步伐，似魔鬼的步伐
        int row[]={0,1,0,-1};
        int col[]={1,0,-1,0};
        int r=0,c=0,di=0;
        //开始转圈
        for(int i=1;i<=n*n;i++){
            //改变脚下的值为i，
            ans[r][c]=i;
            seen[r][c]=1;
            //下一步的位置
            int rr=r+row[di];
            int cc=c+col[di];
            //判断下一步的位置是否合理，是否在矩阵范围之内，还有是否已经走过
            if(rr>=0&&rr<n&&cc>=0&&cc<n&&seen[rr][cc]!=1){
                r=rr;
                c=cc;
            }
            else{
                di=(di+1)%4;
                r=r+row[di];
                c=c+col[di];
            }
        }
        return ans;
    }
};
