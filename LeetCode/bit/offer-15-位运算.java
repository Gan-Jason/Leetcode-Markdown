//这题有两个思路，一个是跟1求与，一个是跟2的i次方求与，即一个除法，一个乘法
//需要注意的是，要把n当作无符号数来看，不然会出现负数的情况，所以做除法的时候要用无符号右移
//2的i次方：1<<i
//还有一种o(logn)方法，就是用n&(n-1)，可以把n的第一位变为0，n=n&(n-1)


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans=0;
        // do{
        //     if((n&1)==1){
        //         ans++;
        //     }
        //     n>>>=1;    //转为正数
        // }while(n>=1);
        for(int i=0;i<32;i++){
            if((n&(1<<i))!=0){    //这里要注意的是，不为0，因为1作左移不一定是求与后不一定是1，
                ans++;
            }
        }
        return ans;
    }
}
