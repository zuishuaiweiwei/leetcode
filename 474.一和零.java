/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
public int findMaxForm(String[] strs, int m, int n) {
        if (strs.length == 0) {
            return 0;
        }
        if (m <= 0 && n <= 0) {
            return 0;
        }
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        int[] count = new int[2];
        for (int k = 1; k <= strs.length ; k++) {
            count[0] = 0;
            count[1] = 0;
            for (int v = 0; v < strs[k - 1].length(); v++) {
                if (strs[k - 1].charAt(v) == '0') {
                    count[0]++;
                } else {
                    count[1]++;
                }
            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][i][j] = dp[k - 1][i][j];
                    if (j >= count[1] && i >= count[0]) {
                        dp[k][i][j] = Math.max(dp[k - 1] [i - count[0]] [j - count[1]] + 1, dp[k - 1][i][j]);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
// @lc code=end

