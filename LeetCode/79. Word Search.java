/*Given a 2D board and a word, find if the word exists in the grid.
*
*The word can be constructed from letters of sequentially adjacent cell,
*where "adjacent" cells are those horizontally or vertically neighboring. 
*The same letter cell may not be used more than once.
*/

    //递归遍历二维数组，查找字符串
    private boolean exist(char[][] board, String word) {
        //从二维数组每个位置出发，遍历数组，判断是否存在目标字符串
        for(int y=0;y<board.length;y++){
            for(int x=0;x<board[y].length;x++){
                //如果存在，则返回true
                if(recursion(board,x,y,word,0))
                    return true;
            }
        }
        return false;
    }

    //递归遍历    
    private boolean recursion(char[][] board,int x,int y,String word,int i){
        //如果已遍历匹配的字符串长度与目标字符串长度一致，则查找结束
        if(i==word.length())
            return true;
        //查找失败条件
        if(y<0 || x<0 || y == board.length || x == board[y].length||word.charAt(i)!=board[y][x])
            return false;
        //将当前遍历位置为'#',避免进入递归时再次遍历当前位置，每个位置只能使用一次
        char temp=board[y][x];
        board[y][x]='#';
        
        //递归查找，方向为上下左右进行，结果为当前位置是否能够查找出目标字符串
        boolean res=recursion(board,x+1,y,word,i+1)||recursion(board,x-1,y,word,i+1)||
                    recursion(board,x,y+1,word,i+1)||recursion(board,x,y-1,word,i+1);
        //恢复当前位置的值，
        board[y][x]=temp;
        return res;                              
    }


}
