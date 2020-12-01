/*
 * @lc app=leetcode.cn id=1 lang=java
 * 时隔很久的第一道算法题，完全没有思路，只能暴力破解
 * 1.两数之和，肯定要遍历，遍历到一个位置，需要知道是否具有适合的数字，
 * 优化思路：数组就两个元素 很适合用hashmap来存储，
 * 先遍历一遍 放到hashmap里（容易忽略自身是目标的一半）
 * 或者直接遍历，检查是否存在map里没有,存在放进去
 * 考察知识点，hashmap 查询是O(1)
 * 
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
      return  hashMap2(nums,target);
           }

    public int [] violence(int[] nums,int target){
        for(int i = 0;i < nums.length; i++){
           for(int j = i+1;j < nums.length; j++){
          int k =  nums[i]+nums[j];
          if(k == target){
              return new int[]{i,j};
          }
       } 
       } 
       return null;
    }

    public int[] hashMap1(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i< nums.length;i++){
            int k = target - nums[i];
            if(map.containsKey(k) && map.get(k)!=i){
                return new int[]{i,map.get(k)};
            }
            // map.put(nums[i],i);
        }
        return null;
    }

    
    public int[] hashMap2(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap();

        for(int i = 0; i< nums.length;i++){
            int k = target - nums[i];
            if(map.containsKey(k) && map.get(k)!=i){
                return new int[]{i,map.get(k)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
// @lc code=end

