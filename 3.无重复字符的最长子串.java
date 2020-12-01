/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        int left = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap();
        for(int i =0 ; i < s.length(); i++){
           if(map.containsKey(s.charAt(i))){
               left = Math.max(left,map.get(s.charAt(i)) +1);
           }
           map.put(s.charAt(i),i);
           max = Math.max(max,i - left +1);
        }
      return max; 
    }
}

// @lc code=end

