//有两种dp方法，一种是bottom up，一种是top down
//首先画树，其次辨别出一个关键点，构成bst的数量关键不在于序列的内容，而是序列的长度，因此序列的长度是一个重复子问题，只要出现相同长度的序列那么这个子问题的答案是一致的
//遍历整个序列n，每次都是作为根节点，然后dfs左边序列和dfs右边序列，问子问题要答案，当前根节点的答案就是left*right，这里是一个排列数，因为左右子树可以有不同的排列。把当前答案记录下来
//最后返回memo[n]即可
//bottom up较容易理解，top down就较难理解，需要先初始化memo[0],memo[1]然后从小往大递推memo的值

class Solution {
    private int[] memo;
    public int numTrees(int n) {
        //Bottom up
        memo=new int[n+1];
        // return dfs(n);

        //Top down
        memo[0]=1;
        memo[1]=1;
        for(int i=2;i<=n;i++){  //这里的i相当于bu里的n
            for(int j=1;j<=i;j++){  //这里的j相当于bu里的i
                memo[i]+=memo[j-1]*memo[i-j]; //j-1是当前根节点i的左边序列，i-j是右边序列
            }
        }
        return memo[n];


    }

    private int dfs(int n){
        if(n<=1){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        int res=0;
        for(int i=1;i<=n;i++){
            int left=dfs(i-1);
            int right=dfs(n-i);
            res+=left*right;  //注意这里是累加的答案，因为n序列中每个元素都可以作为根节点，以及left*right，求排列情况
        }
        return memo[n]=res;

    }
}
