//暴力解，如果第一反应没有很好的思路，就先做一个暴力解，再逐渐优化
//这题主要是二维数组的遍历，容易出错的地方就是指针的移动，多检查这些地方
//也要看清楚题目，别遗漏条件
//还有一点是，判断是否有重复，可以用数组的下标作为元素，数组内容作为元素出现频率

class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length<3||grid[0].length<3){
            return 0;
        }
        int ans=0;
        for(int i=0;i+2<grid.length;i++){
            for(int j=0;j+2<grid[0].length;j++){
                int temp;
                if(grid[i][j]!=5&&isVaild(i,j,grid)){
                temp=grid[i][j]+grid[i][j+1]+grid[i][j+2];
                if(temp==grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]&&temp==grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2]&&temp==
                    grid[i][j]+grid[i+1][j]+grid[i+2][j]&&temp==grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1]&&temp==grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2]&&temp==
                    grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]&&temp==grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j]){
                        ans++;
                    }
                }
            }
            }
        return ans;
    }
    boolean isVaild(int i,int j,int[][] grid){    
        int p=i;
        int[] help=new int[11];
        while(p<=i+2){    //开始错在把变量都初始化在上面，导致q没有重置
            int q=j;
            while(q<=j+2){
                if(grid[p][q]>9||grid[p][q]<1){
                    return false;
                }
                if(++help[grid[p][q++]]>1){
                    return false;
                }
            }
            p++;      //开始错在这里放在第二个循环里面了
        }
        return true;
    }

}
