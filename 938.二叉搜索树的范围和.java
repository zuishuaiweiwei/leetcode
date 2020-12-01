/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return process(root,L,R,0);
    }
    public int process(TreeNode root,int L,int R,int sum){
        if(root == null){
            return sum;
        }
        int val = root.val;
        int l = 0, r = 0;
        if(val < L){
            r = process(root.right,L,R,sum);
            val = r;
        }else if(val > R){
            l = process(root.left,L,R,sum);
            val = l;
        }else{
            l = process(root.left,L,R,sum);
            r = process(root.right,L,R,sum);
            val = l+r+val;
        }
        return val;
    }
}
// @lc code=end

