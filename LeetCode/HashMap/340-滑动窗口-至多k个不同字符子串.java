//求子串，一般用滑动窗口，做这题的时候可能困了，想了许久都没想出来，想到了滑动窗口，以及map记录次数，但是没实现出来
//求k不同字符的子串，可以用map记录字符出现次数，一旦map长度大于k，则开始结算子串长度，并把窗口左指针移动到合适位置
//移动左指针是一个难点，有两种方法：一种是map记录字符的最右index，移动left时只需要移动到index最小的右侧，因为map中记录的都是不同的字符，最小的index意味着能构成新串的位置
//另一种是：map记录字符出现次数，map长度大于k时，map减去left并移动，如果map[left]==0时就移除，说明当前子串已经没有这个字符了。直到map的长度不大于k，再继续移动right的循环
//这里注意，在可以移动left时，说明left指向的每一个字符都是出现在map中的（right已经遍历过了）

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0||s.length()==0){
            return 0;
        }
        int len=s.length();
        int ans=0;
        //用map记录字符出现次数
        // Map<Character,Integer> map=new HashMap<>(50);
        // int i=0,j=0;
        // while(i<len&&j<len){
        //     map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
        //     if(map.size()>k){
        //         ans=Math.max(ans,j-i);
        //         while(map.size()>k){
        //             map.put(s.charAt(i),map.get(s.charAt(i))-1);
        //             if(map.get(s.charAt(i))==0){
        //                 map.remove(s.charAt(i));
        //             }
        //             i++;
        //         }
        //     }
        //     j++;
        // }
        // ans=Math.max(ans,j-i);

        //试图用数组记录字母出现次数，但是没注意题目条件，没有说是字母，可能是符号，符号的话如果只初始化数组长度为26或者没有注意ascii码可能为负数的情况就出错了
        int[] show=new int[128];
        int showLen=0;
        int i=0,j=0;
        while(j<len){
            int pos=s.charAt(j)-0;  //某些符号减字符的话转为ascii可能会为负数，直接减0转为本身的ascii
            if(show[pos]==0){       //记录当前已出现的字符种类数
                showLen++;
            }
            show[pos]++;
            if(showLen>k){
                ans=Math.max(ans,j-i);
                while(showLen>k){   
                    int left=s.charAt(i)-0;
                    show[left]--;
                    if(show[left]==0){
                        showLen--;
                    }
                    i++;
                }
            }
            j++;
        }
        ans=Math.max(ans,j-i);
        return ans;
    }
}
