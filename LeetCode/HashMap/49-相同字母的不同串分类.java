//这题也不是很难，只是需要一点思考，我先是用了暴力法，纯体力劳动的暴力解，代码冗长导致扣细节耗时长，最后还超时了
//其实暴力解也需要一点思考，比如说这题，异构但是具有相同的字符，表明排序后一定是相同的字符串，或者是他们具有相同字符和字符数量
//可以用排序后的字符串作为key，属于该类别的字符串的list作为value，遍历一次原字符串即可，这种方法需要排序
//也可以用数组对每个字符串计数，用字符+字符出现次数作为key，比如"hhhhhu",统计后可以的到"h4u1"的字符串，如果是异构的字符串统计后也是这个key，相同key的原串加入一个数组中作为value。
class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        //没有一点点思考的暴力法，纯体力活，超时了
        // List<List<String>> ans=new ArrayList<>(256);
        // int len=strs.length;
        // Set<Integer> index=new HashSet<>(len);
        // for(int i=0;i<len;i++){
        //     if(!index.contains(i)){
        //         Map<Character,Integer>show=new HashMap<>(16);
        //         int strLen=strs[i].length();
        //         List<String> t=new ArrayList<>(128);
        //         t.add(strs[i]);
        //         index.add(i);
        //         for(int j=0;j<strLen;j++){
        //             show.put(strs[i].charAt(j),show.getOrDefault(strs[i].charAt(j),0)+1);
        //         }
        //         for(int j=0;j<len;j++){
        //             Map<Character,Integer> tShow=new HashMap<>(show);
        //             if(j!=i&&!index.contains(j)&&strs[j].length()==strs[i].length()){
        //                 boolean flag=true;
        //                 for(int k=0;k<strs[j].length();k++){
        //                     int count=0;
        //                     if(!tShow.containsKey(strs[j].charAt(k))||(count=tShow.get(strs[j].charAt(k)))==0){
        //                         flag=false;
        //                         break;
        //                     }
        //                     if(count==1){
        //                         tShow.remove(strs[j].charAt(k));
        //                     }else{
        //                         tShow.put(strs[j].charAt(k),tShow.get(strs[j].charAt(k))-1);
        //                     }
        //                 }
        //                 if(flag&&tShow.size()==0){
        //                     t.add(strs[j]);
        //                     index.add(j);
        //                 }
        //             }
        //         }
        //         ans.add(t);
        //     }
        // }
        // return ans;
        int len=strs.length;
        List<List<String>> ans=new ArrayList<>();
        Map<String,List<String>> map=new HashMap();
        for(int i=0;i<len;i++){
            int[] count=new int[26];
            //保存原串的字符次数
            for(int j=0;j<strs[i].length();j++){
                count[strs[i].charAt(j)-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            //统计原串的次数并组成key
            for(int k=0;k<26;k++){
                if(count[k]>0){
                    sb.append((char)(k+'a'));
                    sb.append(count[k]);
                }
            }
            
            String key=sb.toString();
            //得到该key的list，如果没有则创建
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(strs[i]);
            map.put(key,list);
        }
        for(Map.Entry e:map.entrySet()){
            ans.add((List<String>)e.getValue());
        }
        return ans;
    }
}
