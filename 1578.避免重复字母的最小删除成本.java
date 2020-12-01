/*
 * @lc app=leetcode.cn id=1578 lang=java
 *
 * [1578] 避免重复字母的最小删除成本
 */

// @lc code=start
class Solution {
    public int minCost(String s, int[] cost) {
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = 0 ; i < arr.length ;){
            char ch = arr[i];
            int max = 0;
            int sum = 0;
            while(i < arr.length && arr[i] == ch){
                max=Math.max(cost[i],max);
                sum += cost[i]; 
                i++;
            }
            res +=  (sum - max);
        }
        return res;
    }
}
// @lc code=end

