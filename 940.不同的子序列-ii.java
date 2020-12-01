/*
 * @lc app=leetcode.cn id=940 lang=java
 *
 * [940] 不同的子序列 II
 */

// @lc code=start
class Solution {
    public int distinctSubseqII1(String strs) {
        if(strs.length() < 2){
            return strs.length();
        }
        int mod = (int)1e9+7;
        int [] dp = new int [strs.length()+1];
        int[] x = new int[26];
        Arrays.fill(x,-1);
        for(int i = 0 ; i < strs.length() ; i++){
           int ch =  strs.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 + 1;
            if(x[ch] >= 0){
                dp[i + 1] -= (dp[x[ch]] +1);
            }
            if (dp[i + 1] < 0) dp[i + 1]+=mod ;
            dp[i + 1] %= mod;
            x[ch] = i;
        }
        return dp[dp.length -1];
    }

     public int distinctSubseqII(String strs) {
        int mod = (int)1e9+7;
        long[] dp = new long[26];
        for(char ch : strs.toCharArray()){
            dp[ch - 'a'] = (Arrays.stream(dp).sum() +1) % mod;
        }
        return (int)(Arrays.stream(dp).sum() % mod);
    }
}
// @lc code=end

