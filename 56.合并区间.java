import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1 ; i < intervals.length ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int last_end = list.get(list.size() - 1)[1];
            if(start <= last_end){
                list.get(list.size() -1)[1] = Math.max(end,last_end);
            }else{
                list.add(intervals[i]);
            }

        }
        return list.toArray(new int[0][]);

    }
}
// @lc code=end

