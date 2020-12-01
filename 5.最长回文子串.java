/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {

        public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        
        boolean [][]  dp = new boolean[s.length()][s.length()];
        char[] arr = s.toCharArray();
        for(int i = 0 ;i < dp.length ; i++){
            dp[i][i] = true;
        }

        for(int j =1;j < dp.length ; j++){
            for(int i = 0 ; i < j ; i++){
                if(arr[j]!=arr[i]){
                    dp[i][j] = false;
                }else{
                    if(j -i <3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        int max = 0;
        int l =0,r =0;
            for(int j = 0 ; j<dp.length;j++){
                for(int i = 0; i< j;i++){
                    if(dp[i][j] && j -i +1 > max){
                        l = i;
                        r = j;
                        max = j -i+1;
                                           }
            }
        }


        return s.substring(l,r+1);
    }

   

}


// @lc code=end

