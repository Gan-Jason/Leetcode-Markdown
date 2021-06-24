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

    // private void getAll(String s,int len,int n){   //暴力解，枚举所有情况，再对每个情况进行验证，这里也是回溯
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
        getAll(s+"(",left+1,right,n);   //回溯的操作，在形式参数中传入选择的选项，当递归回来时形参消失
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
    
//2021.6.25 通过画树形图，自己想明白了这个题目的思路：每个位置必须得选一个括号，要么左要么右，一直选到2的2n次方层树叶节点中，此时是一颗满二叉树，只要从这个树中search出答案即可，
//dfs进行search，如果是没有约束条件的话就直接search整棵树，但这里要求括号有效，因此要考虑有效的search路径，base case check:当前的string长度==2n
//还需要剪枝，剪枝的条件清晰：左右括号必须小于<n（等于n时已经加入答案并且递归返回了），且当前答案的右括号数量不能大于左括号的，
        private void dfs(String sb,int n,int left,int right){
        if(sb.length()==2*n){
            ans.add(sb);
            return;
        }
        if(left<n){
            dfs(sb+"(",n,left+1,right);
        }
        if(right<left){
            dfs(sb+")",n,left,right+1);
        }
    }
    
}
