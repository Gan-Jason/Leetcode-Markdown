

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> countMap = new HashMap<>();//用来记录已使用的单词次数
        int wordLength = words[0].length();
        int aryLength = words.length;
        int sl = s.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) { // 只需要滑动 结果串的长度 即可，因为后面会有重复
            if (i + wordLength * aryLength > sl) { // 如果剩余的长度不够一个窗口大小，则结束
                break;
            }
            countMap.clear();
            // 初始化窗口
            for (int j = 0; j < aryLength; j++) {
                // 截取单词长度的子串
                String subStr = s.substring(j * wordLength + i, (j + 1) * wordLength + i);
                // 记录单词次数
                countMap.put(subStr, countMap.getOrDefault(subStr, 0) + 1);
            }

            // 与给定列表匹配单词数量
            for (String word : words) {
                countMap.put(word, countMap.getOrDefault(word, 0) - 1);
                // 如果使用次数清零，则移除该单词，最终想到的结果是该map为空，即为单词出现的次数对应原列表次数
                if (countMap.get(word) == 0) {
                    countMap.remove(word);
                }
            }
            // 开始在当前位置滑动，结束条件为窗口大小<字符串大小，每次滑动一个单词长度
            for (int start = i; start < sl - aryLength * wordLength + 1; start += wordLength) {
                if (start != i) { // 该条件意思是窗口已经滑出去了
                    String rightStr = s.substring(start + wordLength * (aryLength - 1), start + wordLength * aryLength); // 右边滑进来的一个单词
                    // 增加次数
                    countMap.put(rightStr, countMap.getOrDefault(rightStr, 0) + 1);
                    // 次数变动即判断
                    if (countMap.get(rightStr) == 0) {
                        countMap.remove(rightStr);
                    }
                    String leftStr = s.substring(start - wordLength, start); // 左边对应滑出去一个单词，保持窗口大小不变
                    // 减少次数
                    countMap.put(leftStr, countMap.getOrDefault(leftStr, 0) - 1);
                    // 判断
                    if (countMap.get(leftStr) == 0) {
                        countMap.remove(leftStr);
                    }
                }
                // 滑动后，如果次数map清空，则满足答案
                if (countMap.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}