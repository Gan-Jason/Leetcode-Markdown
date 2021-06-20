//这题在微软reactor现场的contest中求主题房间最大面积是一样的题目，小变形
//我的第一次做法错在把两个岛屿的所有自岛屿都求出来了，然后对着岛屿2的子岛屿去岛屿1中判断是否为子集，这个判断是四重循环严重超时。。
//仔细一想，不用求岛屿1的子岛屿，只需要求出岛屿2的子岛屿后去岛屿1中遍历一下是否为1即可。，
class Solution {
    private int n;
    private int m;
//     private boolean valid;
//     private List<List<Island>> islands1=new ArrayList<>();
//     private List<Island> island1;
//     private List<List<Island>> islands2=new ArrayList<>();
    private List<Island> island2;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid1.length;
        m=grid1[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //第一次做法，把两个岛屿都所有子岛屿都求出来了
                // if(grid1[i][j]!=-1&&grid1[i][j]!=0){
                //     valid=true;
                //     island1=new ArrayList<>();
                //     dfs1(grid1,i,j);
                //     islands1.add(island1);
                // }
                if(grid2[i][j]!=-1&&grid2[i][j]!=0){
                    valid=true;
                    island2=new ArrayList<>();
                    dfs2(grid2,i,j);
                    if(isSubIsland(island2,grid1)){   //后面发现只需要判断下岛屿2的子岛屿即可
                        ans++;
                    }
                }
            }
        }
        //第一次做错的判断
        // for(int i=0;i<islands2.size();i++){
        //     List<Island> list2=islands2.get(i);
        //     for(int j=0;j<islands1.size();j++){
        //         List<Island> list1=islands1.get(j);
        //         if(isSubIsland(list1,list2)){
        //             ans++;
        //             break;
        //         }
        //     }
        // }
        return ans;
    }
    public boolean isSubIsland(List<Island> list2,int[][] grid1){
        for(int i=0;i<list2.size();i++){
            Island land2=list2.get(i);
            int x=land2.x;
            int y=land2.y;
            if(grid1[x][y]!=1){
                return false;
            }
        }
        return true;
    }
    
    //第一次做法的判断
//     public boolean isSubIsland(List<Island> list1,List<Island> list2){
//         for(int i=0;i<list2.size();i++){
//             Island land2=list2.get(i);
//             boolean ans=false;
//             for(int j=0;j<list1.size();j++){
//                 Island land1=list1.get(j);
//                 if(land2.x==land1.x&&land2.y==land1.y){
//                     ans=true;
//                     break;
//                 }
//             }
//             if(ans==false){
//                 return false;
//             }
//         }
//         return true;
//     }
    void dfs2(int[][] grid,int i,int j){
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0||grid[i][j]==-1){
            return;
        }
        island2.add(new Island(i,j));
        grid[i][j]=-1;
        dfs2(grid,i+1,j);
        dfs2(grid,i-1,j);
        dfs2(grid,i,j+1);
        dfs2(grid,i,j-1);
    }
    
    
}

class Island{
    public int x;
    public int y;
    public Island(int x,int y){
        this.x=x;
        this.y=y;
    }
}
