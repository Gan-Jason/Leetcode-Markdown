//这题主要还是考察了滑动窗口的知识点，子串是连续的子序列，因此可以用一个start和end作为窗口的左右边框住子串内容
//我以为是单纯的hashmap来存放字符的下标来判断是否已出现，但这样的做法无法获取重复字符后下一个子串的开头，
//应该用start作为窗口的左指针，右指针遍历字符串，当出现重复的字符时，把左指针移动到重复的下一位值，这里有一个小难点是：
//当重复的位置在start的左边是，start不做更新，因为此时重复的位置不在窗口内，而窗口的左边已经全部计算判断过了，不应再重复回去判断
//每次先判断是否需要移动左指针，移动后再计算子串长度

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>(512);    //初始化容量比较省时，这个数字是瞎写的，如果写s的长度最大值，会很耗时，因为那是最糟糕的情况出现的长度
        int ans=0;
        int len=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>=start){    //先判断做指针是否需要移动，即先判断当前的字符是否重复了，只有重复的位置在窗口内再移动
                start=map.get(s.charAt(i))+1;
            }
            ans=Math.max(i-start+1,ans);    //这里用左指针进行计算就比较周全，简练，概括，如果用累加器的话会出现判断多种情况
            map.put(s.charAt(i),i);   //此时要更新下重复元素，或者新增出现字符
        }
        ans=Math.max(s.length()-start,ans);
        return ans;
    }
}
