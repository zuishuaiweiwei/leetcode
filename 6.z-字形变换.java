/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList();
        for(int i = 0;i < numRows; i++){
            list.add(new StringBuilder());
        }
        int i = 0;
        int n = 2 * numRows -2;
        for(char c:s.toCharArray()){
           int x = i++ % n; 
           x =  x < numRows ? x : n -x ;
           list.get(x).append(c);
        }
        StringBuilder build = new StringBuilder();
        for(StringBuilder b : list){
            build.append(b.toString());
        }
        return build.toString();
    }
}
// @lc code=end

