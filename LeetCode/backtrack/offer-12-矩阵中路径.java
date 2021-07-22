//二维矩阵的dfs要注意，从过只从一个位置进入矩阵的话，只有一种情况的dfs，而不能代替遍历原数组，dfs无法遍历每一个位置，得到多种情况
//这题的关键是，要便利每个位置找入口；当前位置的选择不符合要求时，要回溯;dfs应该先判断是否已找到字符串（此时可能下标越界了），否则会导致触发下标越界而返回false的边界条件

class Solution {
    private boolean[][] path;
    private char[][] board;
    private String word;
    int m;
    int n;
    int index;
    public boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        this.board=board;
        this.word=word;
        index=0;
        this.path=new boolean[board.length][board[0].length];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i,int j){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=m||j<0||j>=n||path[i][j]==true){
            return false;
        }

        boolean ans=false;
        if(board[i][j]==word.charAt(index)){    //只有当前的字符满足满足条件才能继续dfs，否则直接返回false
            index++;
            path[i][j]=true;
            ans= dfs(i+1,j)||dfs(i-1,j)||dfs(i,j-1)||dfs(i,j+1);
            if(ans==false){   //即使当前位置满足，但是子问题不满足，整体也不满足，回溯
                index--;
                path[i][j]=false;
            }
        }
        return ans;
    }
}
