import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums[i], i + 1, nums.length - 1, nums);
        }
        return list;

    }

    public void twoSum(int x, int start, int end, int[] nums) {
        int target = 0 - x;
        while (start < end) {

            int res = nums[start] + nums[end];
            if (res > target) {
                end--;
            } else if (res < target) {
                start++;
            } else if (res == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(nums[start]);
                temp.add(nums[end]);
                list.add(temp);
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (end > start && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
        }
    }

}
// @lc code=end
