/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. 
No two characters may map to the same character but a character may map to itself.
*/


public class Solution {
    //判断两个字符串是否同构，同构即为相同的字母映射，s中字母与t中字母的映射是全程一致的。
    //说到映射问题的话，就是涉及Map映射表的使用了，把s中的值作为key，t中作为value存入HashMap中；或者t的字母作为key。往后遍历，如果后面出现的映射关系
    //不一致，则为异构字符串
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
             //把t中字母作为key存入，
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
        
    }
}
