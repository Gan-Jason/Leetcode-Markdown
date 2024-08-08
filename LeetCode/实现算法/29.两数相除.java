class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) { // 判断溢出情况
            return 2147483647;
        }
        if (divisor == 1) { // 边界
            return dividend;
        }
        long d1 = dividend, d2 = divisor; // long防止溢出
        int sign = 1; // 用来判断符号
        if (dividend < 0 && divisor < 0) {
            d1 = -d1; // 这里注意，如果直接赋值d1 = -divisor，当divisor=-2147483648时会导致溢出，因为此时int放不下符号位了
            d2 = -d2;
        } else if (divisor < 0) {
            d2 = -d2;
            sign = -1;
        } else if (dividend < 0) {
            d1 = -d1;
            sign = -1;
        }
        return sign == -1 ? -divide(d1, d2) : divide(d1, d2);
    }

    private int divide(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long p = divisor; // 用来保存除数的递增
        int count = 1; // 初始已经累计消耗了一次，因为dividend>=divisor，至少一次了
        while (dividend >= p + p) {// 当翻倍时仍除不尽的话
            p <<= 1;//让除数翻倍
            count <<= 1;//则累计消耗次数
        }
        // 如果除数翻倍后不够除的话，就让被除数减去当前的除数，剩余的新被除数则继续计算除法：10约等于3*3+(10-3*3)/3, count = 3+x
        return count + divide(dividend - p, divisor);
    }

}