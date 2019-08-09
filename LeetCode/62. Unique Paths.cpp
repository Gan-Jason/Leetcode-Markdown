/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/






class Solution {
public:
    int uniquePaths(int m, int n) {
        //求表格中，从左上角走到右下角的唯一路径之和，也是典型的动态规划题目
        //new一个dp二维数组，每一个位置存放的是到该位置的唯一路径之和，也就是说，当只能向右走或者向下走时，当前位置的和是头顶位置和左边位置的路径数之和
        vector<vector<int>> grid(m,vector<int>(n,0));
        //初始化dp数组的第一列为1
        for(int i=0;i<m;i++){
            grid[i][0]=1;
        }
        //初始化第一行为1
        for(int i=0;i<n;i++)
            grid[0][i]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j]=grid[i-1][j]+grid[i][j-1];
            }
        }
        //grid[m-1][n-1]存放了当前位置的路径之和
        return grid[m-1][n-1];
    }
};
