import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    private boolean[] vi;
    private List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> arr = new ArrayList();
        vi = new boolean[nums.length];
        Arrays.sort(nums);
        process(nums, arr);
        return res;
    }

    public void process(int[] nums, List arr) {
        if (arr.size() == nums.length) {
            res.add(new ArrayList(arr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vi[i] || (i > 0 && nums[i] == nums[i - 1] && !vi[i - 1])) {
                continue;
            }
            arr.add(nums[i]);
            vi[i] = true;
            process(nums, arr);
            vi[i] = false;
            arr.remove(arr.size()-1);
        }
        return;
    }
}
// @lc code=end
