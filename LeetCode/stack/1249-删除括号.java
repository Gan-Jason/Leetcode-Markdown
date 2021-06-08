//这题直接ac，但是时间花销在通过与超时的临界点徘徊...
//看了题解，发现我没有用hashset存放要删除的索引，以及最后处理原字符串的时候，用String+String的方法，其中还有了String.valueOf()的方法，导致很慢
class Solution {
    public String minRemoveToMakeValid(String s) {
        int len=s.length();
        int top=-1;
        int[] stack=new int[len];
        String ans="";
        Set<Integer> index=new HashSet<>();
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                stack[++top]=i;
            }else if(s.charAt(i)==')'){
                if(top==-1){
                    index.add(i);
                }else{
                    top--;
                }
                
            }
        }
        for(int i=0;i<=top;i++){
            index.add(stack[i]);
        }
        StringBuilder sb=new StringBuilder();   //字符串常用的处理工具，效率比直接相加快很多。stringbuilder中是system.arraycopy的操作，直接操作string的话会造成大量的GC
        for(int i=0;i<len;i++){
            if(!index.contains(i)){
                sb.append(s.charAt(i));     //我开始是这么写的，ans+=s.chatAt(i)
            }
        }
        return sb.toString();
    }
}
