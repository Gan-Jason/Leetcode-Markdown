//这题画树没画对，子问题/子状态没定义好，
//错误：试图对字符串进行从左往右拆分，这样会导致出现的重复子问题没办法记录，比如"23","26"，就会重复计算，结果就算大了。
//读清题意，发现对string解码，可以按一个字符解，也可以按两个字符解，可以从右往左，先固定一个/两个，剩下的丢进dfs中，就是子问题了，问子问题要答案。
//为什么要从右往左，因为只需要传参为string长度和string即可，用长度len控制每次计算子问题的当前string
//如果是从左往右的话，也可以，但是用重新拷贝string/子串，花销大一点

class Solution {
    private int[] dp;
    private String s;
    public int numDecodings(String s) {
        int len=s.length();
        this.s=s;
        this.dp=new int[len+1];
        return dfs(len,s);
    }

    private int dfs(int len,String s){
        if(len==0){     //为0设为1，原串不能为0，这里是边界条件，这里为子串的判断，如果是0说明左边的子问题没有答案了，只需要累加固定的字符的答案即可，如果返回0则不正确了
            return 1;
        }
        if(len<=1){
            return s.charAt(0)=='0'?0:1;
        }
        if(dp[len]!=0){
            return dp[len];
        }
        int res=0;
        char y=s.charAt(len-1),x=s.charAt(len-2);
        if(y!='0'){
            res+=dfs(len-1,s);
        }
        int xy=(x-'0')*10+(y-'0');
        if(xy>=10&&xy<=26){ //两位数时的判断条件
            res+=dfs(len-2,s);
        }
        return dp[len]=res;
    }
}
