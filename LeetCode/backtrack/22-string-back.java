//像这种题目，应该先做暴力解，从暴力解可以得到优化的思路
//这种枚举排列的暴力是我比较薄弱的，不知道如何枚举所有情况
//这个题目的枚举排列，其实是经典的回溯，每次选择都只有两种情况，要么选'(',要么选')'，当string的长度达到条件时，就加入答案集合中，每次选完后记得擦除选择，再进行第二个选项。
//从暴力解中得到优化思路，只要出现string不符合括号有效组合/排列的情况，就放弃本次枚举，可以减少递归次数，简称剪枝
//本题中可以得到剪枝的条件是：左括号数量大于n/右括号数量大于n/右括号数量大于左括号；这里前两点比较容易理解，第三点比较难，因为string是先加入左括号，而不可能右括号>左括号的情况发生的，
//只有左括号>右括号的情况发生

class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        // getAll("",0,n*2);
        getAll("",0,0,n);
        return ans;
    }

    // private void getAll(String s,int len,int n){   //暴力解，枚举所有情况，再对每个情况进行验证
    //     if(len==n){
    //         if(valid(s)){
    //             ans.add(s);
    //         }
    //         return;
    //     }
    //     s+="(";
    //     getAll(s,len+1,n);
    //     s=s.substring(0,s.length()-1);
    //     s+=")";
    //     getAll(s,len+1,n);
    //     s=s.substring(0,s.length()-1);
    // }

    private void getAll(String s,int left,int right,int n){   //其实是回溯，也是dfs
        if(left>n||right>n||left<right){
            return;
        }
        if(left==n&&right==n){
            ans.add(s);
            return;
        }
        getAll(s+"(",left+1,right,n);   //回溯的操作，在形式参数中传入选择的选项，当递归回来时行参消失
        getAll(s+")",left,right+1,n);
    }
//     private boolean valid(String s){    //验证字符串是否有效
//         int balance=0;
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='('){
//                 balance++;
//             }else{
//                 balance--;
//             }
//             if(balance<0){
//                 return false;
//             }
//         }
//         return balance==0;
//     }
}
