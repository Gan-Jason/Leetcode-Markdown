//这题用双指针的话会很麻烦，因为一个点：*代表零次或者多次，意味着不确定当前位置选不选，需要一个回溯的过程，选择最优解
//因此用dfs比较合适，dp记录子问题答案
//判断当前问题的状态建立，当前状态分几种情况：1. 字符相等 2. 字符不等 3. '.' 4. '*'；其实123是一样的，只需要判断字符等不等，4是特殊一点，需要联系当前的前一位字符
//p如果前一位不等，则需要舍弃p当前的*和前一位；如果相等，则需要尝试两种选择：选择当前的*最为匹配/不选当前*，取其中最优解，即能匹配整个问题的答案，最后记录当前问题的状态即可

class Solution {
    String s;
    String p;
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        int i=s.length();
        int j=p.length();
        this.dp=new Boolean[i+1][j+1];
        this.s=s;
        this.p=p;
        return dfs(i,j);
    }
    

    private boolean dfs(int i,int j){
        if(i==0&&j==0){   //base case，两个都是空串
            return true;
        }
        if(i==0){   
            while(j>0){   //如果p不为空，则需要判断p是否可以看成空串，即.*/a*/...等形式
                if(p.charAt(j-1)!='*'){
                    return false;
                }
                j-=2;
            }
            return true;
        }
        if(i==0||j==0){   //否则两者其一为空，无法匹配
            return false;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean res=false;
        if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){   //字符相等
            res=dfs(i-1,j-1);
        }else if(p.charAt(j-1)=='*'){   //当前为*
            if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'){ //与p前一位联系，前一位与s当前相等，则选择最优解
                res=dfs(i-1,j)||dfs(i,j-2);
            }else{
                res=dfs(i,j-2);   //否则舍弃p当前位置
            }
        }
        return dp[i][j]=res;
    }
}
