//本题类似消消乐，可以用栈来存放遍历结果
//如果栈不为空且栈尾元素==原字符数组元素，则出栈，
//如果栈为空，则元素入栈
//最后通过栈尾位置构造字符串

class Solution {
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        char[] q=new char[chars.length];    //初始化栈
        int tail=0;
         for (char ch : chars) {      //遍历字符数组
            if(q[tail]!='\0'&&q[tail]==ch){
                q[tail]='\0';   //出栈
                tail--;
            }else{
                q[++tail]=ch;   //入栈
            }
        }
        return new String(q,1,tail);  //栈中元素位置为[1,tail]
    }
}
