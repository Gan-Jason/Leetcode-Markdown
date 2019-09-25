/**
 *
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 
 *Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
 
 
 class Solution {
    //这题可以用动态规划来做，判断s字符串，如果s(n-1)符合要求且s[n]也符合要求，则返回true
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] ans=new boolean[s.length()+1];
        ans[0]=true;
        //i控制s(n)的长度，也就是s(i)，s(i)=s(i-1)+s(j,i)
        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=0;j--){
                if(ans[j]&&wordDict.contains(s.substring(j,i))){
                    ans[i]=true;
                    break;
                }
                    
            }
        }
        return ans[s.length()];
    }
}
