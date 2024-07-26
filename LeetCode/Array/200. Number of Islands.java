/*
*
*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
*An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
*You may assume all four edges of the grid are all surrounded by water.
*/


class Solution {

    //动态规划找出四周临海的岛屿
    public int numIslands(char[][] grid) {
        int n=grid.length;
        
        int count=0;
        if(n==0)
            return 0;
        int m=grid[0].length;
        //一个个陆地去遍历，如果是陆地则都击落为海，如果都是连在一起的陆地，则是一个岛屿；如果不连在一起，重新遍历
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                dfsSink(grid,i,j,n,m);
                ++count; 
                }

            }
        }
        return count;
    }
    private void dfsSink(char[][] grid,int i,int j,int n,int m){
        if(i<0||j<0||i>=n||j>=m||grid[i][j]!='1')return;
        grid[i][j]='0';
        //一个个击沉，把一个岛屿击沉了后，总数加一
        dfsSink(grid,i+1,j,n,m);jiayi
        dfsSink(grid,i-1,j,n,m);
        dfsSink(grid,i,j+1,n,m);
        dfsSink(grid,i,j-1,n,m);
    }
}
