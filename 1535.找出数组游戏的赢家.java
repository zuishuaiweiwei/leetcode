/*
 * @lc app=leetcode.cn id=1535 lang=java
 *
 * [1535] 找出数组游戏的赢家
 */

// @lc code=start

class Solution {
    public int getWinner(int[] arr, int k) {
       if (arr.length == 1) return arr[0];
       if (arr.length == 2) return Math.max(arr[0],arr[1]);

       int con = 0;
       int pre = arr[0];
       for(int i =1 ; i < arr.length && con < k ; i++){
           if (arr[i] < pre){
               con++;
           }else{
               pre = arr[i];
               con = 1;
           }
       }
       return pre;
    }
}
// @lc code=end

