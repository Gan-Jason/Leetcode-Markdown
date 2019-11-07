/*
*
* Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
*
**/


class Solution {
    //动态规划法遍历矩阵，找出最大面积正方形
    public int maximalSquare(char[][] matrix) {
        int ans=0;
        int row=matrix.length;
        if(row==0)return 0;
        int col=matrix[0].length;
        //要遍历到矩阵的最右边和最下边，故需要dp数组增加一维
        //dp[i][j]代表一个正方形的右下角为计算点，存放该点能构成最大的正方形的边长，
        int dp[][]=new int[row+1][col+1];     
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                //如果一个正方形的左上角都不存在，则不需要判断
                //若存在，则找出三个角中最小的那个，再加1
                //因为能构成最大的正方形，要看他的最短的边长是多长
                if(matrix[i-1][j-1]=='1'){
                dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                ans=Math.max(dp[i][j],ans);
                }

            }
        }
        return ans*ans;
    }
}
