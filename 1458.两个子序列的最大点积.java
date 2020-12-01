/*
 * @lc app=leetcode.cn id=1458 lang=java
 *
 * [1458] 两个子序列的最大点积
 */

// @lc code=start
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int [][] dp = new int[nums1.length+1][nums2.length+1];
        for(int[] x:dp){
            Arrays.fill(x,(int)-1e8);
        }

        for(int i = 1 ; i <= nums1.length ;i++){
            for(int j = 1; j <= nums2.length ; j++){
                dp[i][j] = nums1[i-1] * nums2[j -1];
                dp[i][j] = Math.max(dp[i][j],nums1[i-1]*nums2[j-1] + dp[i-1][j-1]);
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j],dp[i][j-1]);
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
// @lc code=end

