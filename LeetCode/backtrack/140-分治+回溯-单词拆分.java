//首先是用分治的思想，把原问题拆分为一个个小问题，先从右往左/从左往右，找到一个字典中存在的单词，把这个单词拿出来，再问剩下的子字符串要答案。假设我们的求答案公式是f(s)=dfs(s);
//则，原问题的答案就是subword+dfs(substring)，
//由于第一个存在的单词可能存在多种情况，因此在第一种情况找到后，擦除当前的单词，并继续从右往左/从左往右查找第二种情况，这就是回溯


class Solution {
    private Set<String> dict;
    private List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0){
            return new ArrayList<>();
        }
        this.dict=new HashSet<>(wordDict);      //hashset用于提高查找字典速度，查找时间花销为o(1)
        this.ans=new ArrayList<>();         
        dfs(s,new ArrayList<String>());
        return ans;
    }
    private void dfs(String s,List<String> tmp){        //tmp用于存放目前已形成的答案字符串的缓存区，一开始我是用String作为行参的，但是String的加减操作太耗时了：tmp+t+" "，涉及运算符重载后再new
        if(s.length()==0){      //当 当前的字符串为空时，结束递归
            StringBuilder sb=new StringBuilder();       //构造答案字符串
            tmp.forEach(o->sb.append(o).append(" "));
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        String t;
        for(int i=1;i<=s.length();i++){
            t=s.substring(0,i);     //我这里是从左往往右找第一个存在的单词
            if(dict.contains(t)){   //找到了
                tmp.add(t);     //加入缓存区
                dfs(s.substring(i,s.length()),tmp); //截掉该单词，并问剩余的子串要答案
                tmp.remove(tmp.size()-1);   //回来后，擦除当前单词，找第二种情况
            }
        }
    }
}
