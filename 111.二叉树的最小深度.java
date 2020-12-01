import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
    //    return process(root, 0);
       return bfs(root);
    }

    public int dfs(TreeNode root,int h){
        if(root == null){
            return h;
        }
        int left = process(root.left, h);
        int right = process(root.right, h);
        h++;
        if(h == 1 && (left == 0 || right == 0)){
            return h +Math.max(left,right);
        }else{
            return h+ Math.min(left,right);
        }
    }
    public int bfs(TreeNode root){
       if(root == null){
           return 0;
       }
       int h = 1;
       LinkedList<TreeNode> list = new LinkedList<>();
       list.push(root);
       while(!list.isEmpty()){
           int sz = list.size();

        for(int i = 0 ; i < sz; i++){
            TreeNode node = list.poll();
            if(node.left == null && node.right == null){
                return h;
            }
            if(node.left != null){
                list.offer(node.left);
            }
            if(node.right != null){
                list.offer(node.right);
            }
        }
        h++;
       }
       return h;
    }
}
// @lc code=end

