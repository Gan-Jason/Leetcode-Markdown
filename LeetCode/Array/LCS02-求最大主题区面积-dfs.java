//二维数组的dfs，求最大连续的房间面积，首先双循环遍历数组，遇到非零或者没遍历过的房间时，进行dfs
//dfs中：
//先判断是否为有效的房间序列，即是否为边界内或者不为0，如果不是则判定为无效的序列，并dfs把该序列置为已遍历过的
//如果有效则再判断是否已遍历过或者与当前主题不一致，如果是则剪枝，不继续遍历当前位置。
//否则将该位置置为已遍历过，并累加面积
//继续dfs当前位置的上下左右方向。

class Solution {
    private int n;
    private int m;
    private boolean valid;
    private int ans;
    private int area;
    private char theme;
    public int largestArea(String[] grid) {
        n=grid.length;
        m=grid[0].length();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i].charAt(j)!='6'&&grid[i].charAt(j)!='0'){
                    area=0;
                    valid=true;
                    theme=grid[i].charAt(j);
                    dfs(grid,i,j);
                    if(valid){
                        ans=Math.max(ans,area);
                    }
                }

            }
        }
        return ans;
    }
    private void dfs(String[] grid,int i,int j){
        char c;
        if(i<0||j<0||i>=n||j>=m||(c=grid[i].charAt(j))=='0'){   //递归结束条件
            valid=false;
            return;
        }
        if(c!=theme||c=='6'){   //剪枝操作，不符合则不继续往下递归
            return;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(grid[i]);
        sb.setCharAt(j,'6');
        area++;
        grid[i]=sb.toString();
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
