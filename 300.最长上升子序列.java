/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长上升子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS1(int[] nums) {
       if(nums.length == 0 || nums.length == 1){
           return nums.length;
       } 
       int [] dp = new int[nums.length];
       for(int i = 0; i < dp.length ; i++){
           dp[i] = 1;
       }
       int max = 1;
       for(int i = 1; i < nums.length ; i++){
           for(int j = 0 ; j < i; j++){
               if(nums[i] > nums[j]){
                   dp[i] = Math.max(dp[j] + 1,dp[i]);
               }
           }
        max = Math.max(dp[i],max);

       }
       return max;
    }

    public int lengthOfLIS(int[] nums) {
       if(nums.length == 0 || nums.length == 1){
           return nums.length;
       } 
       int [] tail = new int[nums.length];
       tail[0] = nums[0];
       int len = 1;
       for(int i = 1 ; i < nums.length ; i++ ){
           if ( nums[i] > tail[len -1]){
               tail[len++] = nums[i];
           }else{
               int l = 0 ,r = len - 1;
               // 需要注意这里的每一个比较符号，错一个就得不到正确结果
               // 这里有点碰运气的意思，边界条件不是很清楚 
               while( l <= r){
                   int mid = (l + r) >>1;
                   if(tail[mid] >= nums[i]){
                       r = mid - 1;
                   }else {
                       l = mid + 1;
                   }
               }
               tail[l] = nums[i];
           }
       }
      
       return len;
    }
}
// @lc code=end

