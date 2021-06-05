//模拟线程函数执行时，栈的运行情况。这种题目最重要的是理解数据结构、变量的含义
// 进栈的都是已经开始运行的函数，并且栈顶的是正在运行的函数
//维护一个pre变量，表示当前函数之前的已运行时间
//如果是start，则pre=start，如果是end，则pre=start+1.因为start是从一秒的开始时结算，end是一秒的结束时结算
//遇到start就进栈，进栈前，先计算栈里面正在运行的函数的运行时间，因为新的函数进栈，前面的就要挂起了。计算方式是，栈顶id运行时间=当前入栈函数的时间戳-pre，不需要+1，因为两者都是从一秒的开始算的
//遇到end，则出栈，出栈的id运行时间=end时间戳-pre+1，因为start是秒的开始，end是秒的结束，所以还要加上1秒
//每次进栈出栈都计算栈顶函数的时间即可，pre表示当前线程已运行的时间

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        Deque<Integer> stack=new ArrayDeque<>();
        int pre=0;
        for(int i=0;i<logs.size();i++){
            String[] t=logs.get(i).split(":");
            int id=Integer.parseInt(t[0]);
            String tag=t[1];
            int ts=Integer.parseInt(t[2]);
            if(tag.equals("start")){
                if(!stack.isEmpty()){
                    ans[stack.peek()]+=ts-pre;
                }
                pre=ts;
                stack.push(id);
            }else{
                id=stack.pop();
                ans[id]+=ts-pre+1;
                pre=ts+1;
            }  
        }
        return ans;
    }
 
}
