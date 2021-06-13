//这题花了好多功夫，下次遇到偏题不要纠结
//知识点：1. 字符的出现频率计数可以用ascii，通过-'a'/+'a'得到下标/字符；2. 字符的选取不一定每次只选一个，这题要相邻的不重复字符，可以每次选两个不同的，则不需要特殊判断了。
//错误经验：如果遇到类似的：有思路，但是没有章法的思路，就是瞎碰的，别深究，别耗时；暴力解也是有清晰的思路的，以及通顺的逻辑；而不是充斥着许多特殊判断。
class Solution {
    public String reorganizeString(String s) {
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        //字母的出现频率计数可以用acsii作为下标
        int[] count=new int[26];
        int max=0;
        PriorityQueue<Character> pq=new PriorityQueue(new Comparator<Character>(){
            public int compare(Character o1,Character o2){
                return count[o2-'a']-count[o1-'a'];
            }
        });
        for(int i=0;i<len;i++){
            count[s.charAt(i)-'a']++;
            max=Math.max(max,count[s.charAt(i)-'a']);
        }
        for(int i=0;i<26;i++){
            if(count[i]>0){
                pq.offer((char)(i+'a'));
            }
        }
        while(pq.size()>1){
            Character c1=pq.poll();
            Character c2=pq.poll();
            sb.append(c1);
            sb.append(c2);
            count[c1-'a']--;
            count[c2-'a']--;
            if(count[c1-'a']>0){
                pq.offer(c1);
            }
            if(count[c2-'a']>0){
                pq.offer(c2);
            }
        }
        if(pq.size()>0){
            Character t=pq.poll();
            if(count[t-'a']>1){
                return "";
            }else{
                sb.append(t);
            }
        }
        return sb.toString();
        
        // //暴力解，按出现频率排序，每次先选频率大的字符，并标记为已选，然后重新排序并从0开始遍历原串，排除已选字符并选取最大频率字符。如果在原串遍历一遍还没有选取的情况下，退出循环，复杂度为o(n^2logn)
        // List<Map.Entry<Character,Integer>> list=new ArrayList<>(count.entrySet());
        // Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
        //     public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
        //         return o2.getValue()-o1.getValue();
        //     }
        // });
        // char used='0';
        // int i=0;
        // boolean flag=false;
        // do{
        //     flag=false;
        //     while(i<list.size()){
        //         if(used!=list.get(i).getKey()&&list.get(i).getValue()!=0){
        //             sb.append(list.get(i).getKey());
        //             list.get(i).setValue(list.get(i).getValue()-1);
        //             used=list.get(i).getKey();
        //             flag=true;
        //             Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
        //             public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
        //                 return o2.getValue()-o1.getValue();
        //                 }
        //             });
        //             i=0;
        //             continue;
        //         }
        //         i++;
        //     }
        // }while(flag!=false);
        // //错误思路1，用出现频率做大顶堆，每次取堆顶元素并减去相应的次数后重新调整堆顶元素，当无法调整时认为是不能重构并返回“”，错误点：如果出现频率是311时出错，此时堆顶弹出一次后，堆结构没有改变，但是仍可以重构
        // Map.Entry<Character,Integer>[] map=list.toArray(new Map.Entry[list.size()]);
        // for(int i=map.length/2-1;i>=0;i--){
        //     shift(map,i,map.length-1);
        // }
        // StringBuilder sb=new StringBuilder();
        // while(map[0].getValue()!=0){
        //     sb.append(map[0].getKey());
        //     map[0].setValue(map[0].getValue()-1);
        //     if(!shift(map,0,map.length-1)){
        //         return "";
        //     }
        // }


        // return list.get(0).getValue()==0?sb.toString():"";
    }
    //错误思路2，按出现频率重排原字符串，即aabba->aaabb,然后遍历枚举该字符串，维护字符串ans，当char[i]!=ans.lastChar时，将char[i]加入ans，
    //并把char[i]从原字符串中删除，重新遍历；如果相等，则继续遍历原字符串；错误点：当原字符串是aabbcc时，按上述说法，ans构成为abab时，会重新遍历
    //愿字符串，将变为ababcc，则判断为无法重构
    // private char[] sort(char[] c){
    //     int len=c.length;
    //     Map<Character,Integer> map=new HashMap<>();
    //     for(int i=0;i<len;i++){
    //         map.put(c[i],map.getOrDefault(c[i],0)+1);
    //     }
    //     List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());
    //     Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>(){
    //         public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2){
    //             return o2.getValue()-o1.getValue();
    //         }
    //     });
    //     StringBuilder sb=new StringBuilder();
    //     char[] ans=new char[len];
    //     int k=0;
    //     for(int i=0;i<list.size();i++){
    //         int size=list.get(i).getValue();
    //         char t=list.get(i).getKey();
    //         for(int j=0;j<size;j++){
    //             ans[k++]=t;
    //         }
    //     }
    //     return ans;
    // }

    private boolean shift(Map.Entry<Character,Integer>[] map,int start,int end){
        int i=start,j=2*i+1;
        Map.Entry<Character,Integer> t=map[start];
        boolean flag=false;
        while(j<=end){
            if(j<end&&map[j].getValue()<map[j+1].getValue()){
                j++;
            }
            if(t.getValue()<=map[j].getValue()){
                map[i]=map[j];
                i=j;
                j=2*j+1;
                flag=true;
            }else{
                break;
            }
            map[i]=t;
        }
        return flag;
    }
}
