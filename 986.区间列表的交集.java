import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=986 lang=java
 *
 * [986] 区间列表的交集
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> list = new ArrayList();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int a_start = A[i][0];
            int a_end = A[i][1];
            int b_start = B[j][0];
            int b_end = B[j][1];
            if(a_end >= b_start && a_start <= b_end){
                list.add(new int[]{Math.max(a_start,b_start),Math.min(a_end,b_end)});
            }
            if(a_end > b_end){
                j++;
            }else{
                i++;
            }
        }
        return list.toArray(new int[0][]);

    }
}
// @lc code=end
