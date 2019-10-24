/*
*
*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
*  
* A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
*
*/


class Solution {
      //电话号码映射
      Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
      }};
        //存放结果数组
        List<String> ans=new ArrayList<String>();
        //回溯法组合电话键字母的所有合适的情况
        public void backtrack(String combination,String next_digits){
            //数字字符串为空，则结束回溯
            if(next_digits.length()==0)
                ans.add(combination);
            else{
                //获取数字字符串第一个数字
                String digit=next_digits.substring(0,1);
                //得到该数字映射的字母字符串
                String letters=phone.get(digit);
                //开始继续遍历，把当前的字符串的第一个字符添加到字符串结果中
                for(int i=0;i<letters.length();i++){
                    //获取当前字符串的第一个字符
                    String letter=letters.substring(i,i+1);
                    //回溯，把当前字符串结果也传进去
                    backtrack(combination+letter,next_digits.substring(1));
                }
            }
        }
        public List<String> letterCombinations(String digits) {
        
            if(digits.length()!=0)
                backtrack("",digits);
            return ans;
    }
}
