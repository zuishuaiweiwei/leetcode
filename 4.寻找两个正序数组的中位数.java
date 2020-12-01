/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
   public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 =  nums1.length  ;
        int l2 =  nums2.length  ;
        if(l2 < l1){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left = 0;
        int rigth = l1 -1;
        int mid = (l1 + l2 +1) /2;
        int min = 0,max = 0;
        while(true){
            int point = (left + rigth) /2;
            int c2 = mid - point;

            int nums1LeftMax = point==0 ? Integer.MIN_VALUE : nums1[point - 1];
            int nums1RightMin = point==l1 ? Integer.MAX_VALUE : nums1[point];
            int nums2LeftMax = c2==0 ? Integer.MIN_VALUE : nums2[c2 - 1];
            int nums2RightMin = c2==l2 ? Integer.MAX_VALUE : nums2[c2];

            if(nums1LeftMax <= nums2RightMin && nums1RightMin >= nums2LeftMax){
                max = Math.max(nums1LeftMax,nums2LeftMax);
                min = Math.min(nums1RightMin,nums2RightMin);
                break;
            }else if(nums1LeftMax > nums2RightMin){
                rigth -= 1;
            }else if(nums1RightMin < nums2LeftMax){
                left +=1;
            }

        }
        
        return (l1 + l2) % 2 == 0 ? (min + max) * 0.5 : max;

    }

}
// @lc code=end

