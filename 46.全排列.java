import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    private  List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> arr = new ArrayList();
        process(nums,arr);
        return res;
    }

    public void  process(int[] nums,ArrayList list){
        if(nums.length == list.size()){
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            process(nums, list);
            list.remove(list.size() - 1);
        }
        return ;
    }
}
// @lc code=end

