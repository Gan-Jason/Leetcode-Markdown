// 思路：用栈校验括号的有效性，同时需要记录能够计算长度的下标
// 因为栈中保存的已经可以保证都是有效的括号，只需要在栈底保存一个当前括号对的起始位置就行，可以用第一个无效右括号的下标作为标记
// 初始化时没有第一个无效右括号就用-1占位，-1可以满足长度计算的用途


class Solution {
    public int longestValidParentheses(String s) {
        int maxl = 0;
        int[] stack = new int[s.length() + 1];
        int top = 0;
        stack[0] = -1; //初始化栈
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') { // 遇到右括号则出栈
                --top;
            } else {
                stack[++top] = i; // 否则入栈
            }
            if (top == -1) { // 如果出栈一个括号后栈为空，则当前的括号是右括号，即第一个无效的右括号，以它为下一个有效括号段的起始位置并记录栈中
                stack[0] = i;
                top = 0;
            } else { // 如果栈不为空，则计算当前括号的长度 i - stack[top] 并更新最大值
                maxl = Math.max(maxl, i - stack[top]);
            }
        }
        return maxl;
    }
}