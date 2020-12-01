import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1288 lang=java
 *
 * [1288] 删除被覆盖区间
 */

// @lc code=start
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
       int res = 0;
       int max = 0;
       for(int i = 0 ; i < intervals.length ; i++){
           int end = intervals[i][1]; 
           if( end > max){
               res++;
               max = end;
           }
       }
       return res;
    }
}
// @lc code=end

