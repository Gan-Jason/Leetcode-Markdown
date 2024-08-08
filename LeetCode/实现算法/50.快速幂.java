class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double ans = pow(x, Math.abs(n)); // 为了方便n<0时，直接先算分母，再求倒数；n有可能会溢出（n=-2147483648），所以要用long
        return n < 0 ? 1 / ans : ans;
    }

    private double pow(double x, long n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double tmp = pow(x, n / 2); // 就是先对半拆成两个因数再求积
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x; // 但是有可能这个指数是奇数，所以要多乘一次
    }
}