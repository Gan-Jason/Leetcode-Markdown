//计算数组中的sum[i,j]，->sum[i,j]=sum[j]-sum[i-1];sum[i]表示数组中从0到i的元素和，可以把计算结果保存在原数组中，需要计算结果时直接取出来即可
//这里可以用懒汉模式，即当需要计算时再计算，

class NumArray {
    private int[] dp;
    private int size;
    public NumArray(int[] nums) {
        size=0;
        dp=nums;
    }
    
    public int sumRange(int left, int right) {
        if(right>=size){    //当right大于目前计算的结果长度时，再继续计算到right，其余情况直接返回即可，这种思想可以防止多余计算，有些结果根本无人问津，则不需要提前计算好
            for(int i=size+1;i<=right;i++){
                dp[i]=dp[i-1]+dp[i];
            }
            size=right;   //更新当前计算的长度
        }
        return dp[right]-(left>0?dp[left-1]:0);  //直接返回。要注意left是否为0，如果是0就直接返回sum[right]
    }
}
