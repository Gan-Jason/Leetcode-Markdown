// 先dp得到哪些子串是回文串，再通过回溯切割子串


class Solution {

    private List<List<String>> ans = new ArrayList<>();
    private int sLen;
    private boolean dp[][];

    public List<List<String>> partition(String s) {
        int len = s.length();
        sLen = len;
        dp = new boolean[len][len];

        // 回文串的dp从后往前填表就不会出现误判的情况，比如"abbab"，从前往后的话[0,3]=dp[1,2]&&'a'=='a'，但是[1,2]还没填，导致误判
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j - i + 1 >= 3) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
            }
        }
        dfs(s, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int i, List<String> tmpList) {
        if (i == sLen) { // 切割完了
            ans.add(new ArrayList<>(tmpList));
        }

        for (int j = i; j < sLen; j++) {
            if (dp[i][j]) {//[i,j]为回文
                tmpList.add(s.substring(i, j + 1));
                dfs(s, j + 1, tmpList);//加入当前子串[i,j]并继续往后切
                tmpList.remove(tmpList.size() - 1);// 回溯，丢弃当前子串，往后切
            }
        }
    }
}