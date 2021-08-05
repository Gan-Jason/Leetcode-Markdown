//这题全用回溯的话时间复杂度很高
//回溯是可以剪纸的，这里只需要找到第k个序列即可，然而排列数是有规律的，n个数的排列有n!个情况，则判断k和n!的关系，
//发现规律，每个以同一个数字开头的排列数，比如以1开头的，有n!/n种情况，如果n=3,则每个不同开头的数都有2种情况：123，132，213，231，312，321
//回溯的时候先找到第一个数符合条件的，这点很重要，比如要找到第五个数，则判断k和2比较，肯定不在前两组里面，答案在第三组，以3开头的数，然后k-=2*2，这里有个技巧
//每判断一次k和n!/n，就把k变化一次，k-=n!/n，即不在一个组，就减去这个组的数量。dfs的时候，k和组数都要相应的变化为新的排列长度
//比如第一个数字找到后，就是找后面两个数的全排列了。

class Solution {
    int n;
    boolean[] picked;
    StringBuilder sb=new StringBuilder();
    public String getPermutation(int n, int k) {
        this.picked=new boolean[n+1];
        this.n=n;
        int groupNum=1;
        for(int i=1;i<=n;i++){
            groupNum*=i;
        }
        dfs(0,k,groupNum);
        return sb.toString();
    }

    private void dfs(int index,int k,int groupNum){
        if(sb.length()==n){
            return;
        }
        groupNum=groupNum/(n-sb.length());    //找到当前长度的n!/n，
        for(int i=1;i<=n;i++){
            if(!picked[i]){
                if(k>groupNum){   //如果k不在当前的组数中，迭代k
                    k-=groupNum;
                    continue;
                }
                sb.append(i);   //选好第一个位置
                picked[i]=true;
                dfs(i+1,k,groupNum);    //递归后面的位置。
                return;     //一旦递归完成后就是找好了，直接剪枝
            }
        }
    }
}
