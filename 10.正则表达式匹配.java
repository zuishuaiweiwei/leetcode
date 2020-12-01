/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String text, String pattern) {

       text = " " + text ;
       pattern = " " + pattern ;
       boolean [][] dp = new boolean[text.length() ][pattern.length() ]; 
       dp[0][0] = true;
        for(int i =1; i< dp[0].length;i++){
           if(pattern.charAt(i) == '*' && dp[0][i -2]){
               dp[0][i] = true;
           }
       }

       for(int i = 1 ; i < dp.length; i++){
           for(int j = 1 ;j < dp[i].length ; j++){

               if(pattern.charAt(j) == '*'){
                   if(pattern.charAt(j - 1 )== text.charAt(i) || pattern.charAt(j - 1) == '.'){
                       dp[i][j] = dp[i - 1][j] || dp[i][j - 2] || dp[i][j - 1];
                   }else{
                      dp[i][j] =  dp[i][j -2];
                   }
               }else if(pattern.charAt(j)== text.charAt(i) || pattern.charAt(j) == '.'){
                   dp[i][j] = dp[i - 1][j - 1];
               }else{
                   dp[i][j] = false;
               }

           }
       }
       return dp[text.length() -1][pattern.length() -1];


}
}
// @lc code=end

