//这题要求仔细处理边界条件，比如底数是0，底数是负数，指数是0，指数是负数，底数/指数是1，这些情况的处理
//还要注意大数溢出的问题，如果指数是整型的最小值，那么取绝对值的时候转为整型会溢出，需要转为长整型
//如果使用循环一个个相乘实现指数函数，有点慢，超时
//仔细思考下，这些数相乘都是形成子问题的，可以用分治的思想，求一个数的偶数次方，等于这个数的一半的数相乘，如果是奇数次方，则：a^n=a^(n/2-1)*a^(n/2-1)*a，举个例子：5^5=5^2*5^2*5,

class Solution {
    public double myPow(double x, int n) {
        if(n==0||x==1.0){
            return 1.0;
        }
        double ans=1.0;
        long p=n;
        if(n<0){
            p=n==-2147483648?2147483648l:-n;
        }
        ans=pow(x,p);
        if(n<0){
            ans=1/ans;
        }
        return ans;
}

    private double pow(double x,long n){    //分治处理
        if(n==0){
            return 1.0;
        }
        if(n==1){
            return x;
        }
        double res=pow(x,n>>1); //使用位运算
        res*=res;
        if((n&1)==1){   //判断奇偶
            res*=x;
        }
        return res;
    }
}
