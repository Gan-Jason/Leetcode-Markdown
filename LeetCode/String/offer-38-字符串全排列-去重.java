//全排列是让我头疼的事，字符串/数组的递归，回溯，要用循环
//这题用的是交换法，先用分治，把字符串看作两个部分，第一部分是第一个字符，第二部分剩下的字符，
//求整个字符串的全排列，看作两步，第一步求所有可能出现在第一个位置的字符，设原字符串长度为n，则第一个位置可能出现的情况为n种，第二个位置为n-1，...
//第一个位置求法为，与后面的所有字符交换，这里明显是个循环的表述，
//第二步为，求后面字符的全排列。这种描述就是递归的定义，后面字符的全排列求法如上：固定第一个，求后面的...
//要注意的是，当第一个位置的固定后，求出这个位置后的所有全排列，就要把这个位置还原，即把它换回原字符串的样子

class Solution {
    List<String> ans=new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return ans.toArray(new String[0]);
        
    }

    private void dfs(int x){
        if(x==c.length-1){
            ans.add(new String(c));
            return;
        }
        Set<Character> set=new HashSet<>();   //去重，用来放当前位置已出现的字符，如果当前位置出现过了就不继续了
        for(int i=x;i<c.length;i++){
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i,x);    //固定第一个位置，即找出它可能出现的所有情况，和后面的交换
            dfs(x+1);   //递归求后面的全排列
            swap(i,x);  //本位置本字符全排列算完后，还原排列顺序，就是说当递归回到第一个位置时，后面的子串位置其实都已经还原了
        }
    }

    private void swap(int x,int y){
        char t=c[x];
        c[x]=c[y];
        c[y]=t;
    }
}
