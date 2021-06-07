//实现栈的min函数，并且每个操作都是o(1)的时间花销
//我一开始想到的是push时把栈中最小值保存下来，min()直接返回这个最小值即可，但是如果把最小值pop出栈，要怎么办？我往要重新找最小值的方向想了，这样的话，pop最坏情况时o(n)，
//如果转换下思路，再把次小值保存下来，次次小值保存下来...即维护多一个空间保存每次push的最小值，用空间换时间
//这里可以用辅助栈，每次push时，都把当前栈的最小值保存到辅助栈中，pop时，把辅助栈中的栈顶元素也出栈，则辅助栈的栈顶随时保存了当前的最小值，min()直接使辅助栈弹出即可
class MinStack {
    int[] stack;
    int[] minStack;
    int top;
    int minTop;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new int[7500];
        minStack=new int[7500];
        top=-1;
        minTop=-1;
    }
    
    public void push(int val) {
        stack[++top]=val;
        if(minTop==-1){   //栈为空时的处理
            minStack[++minTop]=val;
        }else{
            minStack[++minTop]=Math.min(val,minStack[minTop-1]);
        }
        
    }
    
    public void pop() {
        if(top>=0){
            top--;
            minTop--;
        }
    }
    
    public int top() {
        return top>=0?stack[top]:-1;
    }
    
    public int min() {
        return top>=0?minStack[minTop]:-1;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
