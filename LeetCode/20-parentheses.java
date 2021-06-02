//这题用栈来放左括号，判断右括号与左括号是否匹配的方法比较多，可以直接switch，可以用map，可以用acsii等
//我第一做法就是直接switch，先把左括号入栈，遇到右括号就switch栈顶元素，如果不匹配则返回false，否则出栈并继续遍历字符串
//字符串的题目，不一定上来就转为数组，有些是可以直接用charAt遍历string的
class Solution {
    public boolean isValid(String s) {
        char[] c=s.toCharArray();
        Deque<Character> stack=new ArrayDeque<>();
        
        for(int i=0;i<c.length;i++){
            while(c[i]=='{'||c[i]=='['||c[i]=='('){
                stack.push(c[i++]);
                if(i==c.length){
                    return false;
                }
            }
            if(stack.isEmpty()){
                return false;
            }
            char t=stack.pop();
            switch(t){        //如果括号的顺序不对的话要怎么处理，比如说([{}])
                case '(':
                    if(c[i]==')'){
                        break;
                    }else{
                        return false;
                    }
                case '[':
                    if(c[i]==']'){
                        break;
                    }else{
                        return false;
                    }
                case '{':
                    if(c[i]=='}'){
                        break;
                    }else{
                        return false;
                    }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
