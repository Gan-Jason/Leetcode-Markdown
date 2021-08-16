//顺序截取字符串，本质上就是暴力search
//由于当前截取的只满足当前的条件，而不满足全局的条件，所以有一个回溯的过程
//因此就是一个典型的回溯题
class Solution {
    private List<String> ans;
    private String s;
    public List<String> restoreIpAddresses(String s) {
        this.ans=new ArrayList<>();
        this.s=s;
        dfs(0,new ArrayList(4));
        return ans;
    }

    private void dfs(int index,List<String> list){
        if(list.size()==4&&index==s.length()){    //满足全局条件后，加入ans，结束递归
            StringBuilder sb=new StringBuilder();
            list.forEach(ip->sb.append(ip).append("."));
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        if(index>=s.length()||list.size()>=4){    //全局条件不满足，也结束递归
            return;
        }
        if(s.charAt(index)=='0'){   //特殊case
            list.add("0");
            dfs(index+1,list);
            list.remove(list.size()-1);
        }else{
            for(int len=1;len<=3&&index+len<=s.length();len++){   //局部条件的判断，这里因为每一小段的ip长度是有条件的，可以用这个条件做筛选
                String sub=s.substring(index,index+len);
                if(Integer.valueOf(sub)<=255&&Integer.valueOf(sub)>=0){   //判断该段ip是否在合理区间内
                    list.add(sub);
                    dfs(index+len,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

}
