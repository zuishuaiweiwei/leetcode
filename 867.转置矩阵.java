/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] A) {
        int iLen = A.length;
        int jLen = A[0].length;
        int [][] ret = new int[jLen][iLen ];
        for(int j =0 ;j < jLen ; j++){
            for(int i = 0; i < iLen ; i++){
                ret[j][i] = A[i][j];
            }
        }
        return ret;
    }
}
// @lc code=end

