/*
*
*
* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
*
* The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
*
* Now consider if some obstacles are added to the grids. How many unique paths would there be?
*
*/

class Solution {
    //动态规划找出到达最右下角的路径数，dp数组为存储当前位有几种到达的方案，
    //dp[i][i]=dp[i-1][j]+dp[i][j-1],当前位置的方案等于上一位的方案加左一位的方案
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i=0,j=0;
        //dp数组初始化为0
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        //初始化dp数组第一位
        dp[0][0]=(dp[0][0]==1)?0:1;
        //初始化dp数组第一行
        for(i=0;i<obstacleGrid[0].length;i++){
            if(obstacleGrid[0][i]==1)
                dp[0][i]=0;
            else if(i!=0){
                dp[0][i]=dp[0][i-1];
            }
                
        }
        //如果只有一行，则返回
        if(obstacleGrid.length<2)
            return dp[0][i-1];
        //初始化dp数组第一列
        for(i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1)
                dp[i][0]=0;
            else if(i!=0){
                dp[i][0]=dp[i-1][0];
            }
                
        }
        如果只有一列，则返回
        if(obstacleGrid[0].length<2)
            return dp[i-1][0];
        //动态规划，把问题分为许多小问题，每一步都会用到上一步的结果
        for(i=1;i<obstacleGrid.length;i++){
            for(j=1;j<obstacleGrid[0].length;j++){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    
                }else{
                    dp[i][j]=0;
                }
            }
            
        }
        return dp[i-1][j-1];
        
    }
}
