/*
 * @lc app=leetcode.cn id=1074 lang=java
 *
 * [1074] 元素和为目标值的子矩阵数量
 */

// @lc code=start
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] prefix = new int[n + 1][m + 1];

        for (int i = 1; i < prefix.length; i++) {
            for (int j = 1; j < prefix[1].length; j++) {
                prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] + matrix[i - 1][j - 1] - prefix[i - 1][j - 1];
            }
        }
        int ret = 0;
        for (int x1 = 1; x1 < prefix.length; x1++) {
            for (int y1 = 1; y1 < prefix[0].length; y1++) {
                for (int x2 = x1; x2 < prefix.length; x2++) {
                    for (int y2 = y1; y2 < prefix[0].length; y2++) {
                        if (prefix[x2][y2] - prefix[x2][y1 - 1] - prefix[x1 - 1][y2] + prefix[x1 - 1][y1 - 1] == target) {
                            ret++;
                        }
                    }
                }
            }
        }
        return ret;
    }

}
// @lc code=end

