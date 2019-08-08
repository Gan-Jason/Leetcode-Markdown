/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
which minimizes the sum of all numbers along its path.
Note: You can only move either down or right at any point in time.
*/

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
    //动态规划法，典型的题目，我这个自己写的动态规划有点臃肿和不熟练
        vector<int> temp(grid[0].size(),0);
        vector<vector<int>> dp(grid.size(),temp);
        //初始化dp数组
        dp[0][0]=grid[0][0];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid[0].size();j++){
                //循环遍历真个矩阵，当i，j不是边界时，dp[i][j+1],dp[i+1][j]存放当前最小的路径之和
                if(i!=grid.size()-1&&j!=grid[0].size()-1){
                if(dp[i][j+1]==0){
                    dp[i][j+1]=dp[i][j]+grid[i][j+1];}
                else if(dp[i][j+1]!=0){
                    //如果dp[i][i+1]非空，则取最小值
                    dp[i][j+1]=min(dp[i][j+1],(dp[i][j]+grid[i][j+1]));
                }
                if(dp[i+1][j]==0)
                    dp[i+1][j]=dp[i][j]+grid[i+1][j];
                else if(dp[i+1][j]!=0)
                    dp[i+1][j]=min(dp[i+1][j],(dp[i][j]+grid[i+1][j]));
                }
                else{
                //当遍历到边界时，同理更新dp数组，存放下一位的最小路径长度，当然，右边界只需要往下遍历，下边界只需要往左遍历
                    if(i==grid.size()-1&&j!=grid[0].size()-1){
                        if(dp[i][j+1]==0){
                            dp[i][j+1]=dp[i][j]+grid[i][j+1];}
                        else if(dp[i][j+1]!=0){
                            dp[i][j+1]=min(dp[i][j+1],(dp[i][j]+grid[i][j+1]));
                        }
                    }
                    if(j==grid[0].size()-1&&i!=grid.size()-1){
                        if(dp[i+1][j]==0)
                            dp[i+1][j]=dp[i][j]+grid[i+1][j];
                        else if(dp[i+1][j]!=0)
                            dp[i+1][j]=min(dp[i+1][j],(dp[i][j]+grid[i+1][j]));
                        
                    }
                }
                //printf("dp[%d][%d]:%d ",i,j,dp[i][j]);

            }      
        //cout<<endl;
        }
        //当然，典型的动态规划有更标准的写法。
        return dp[grid.size()-1][grid[0].size()-1];
    }
};



//标准DP算法，dp数组是算后一位的，即是求当前位由前一位来计算
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size(); 
        vector<vector<int> > sum(m, vector<int>(n, grid[0][0]));
        for (int i = 1; i < m; i++)
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        for (int j = 1; j < n; j++)
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                sum[i][j]  = min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
        return sum[m - 1][n - 1];
    }
};
