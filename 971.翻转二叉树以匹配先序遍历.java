import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=971 lang=java
 * 没有做过类似的题，完全没有头绪，感觉需要知道先序遍历的值 和 二叉树的位置关系，首位肯定相等,如果不相等只有替换左右节点的操作，完全不需要知道替换完是否相等，只要需要不相等的就交换,如何设计递归才能在每次递归的时候知道 3 次递归需要匹配的值,是不是想复杂了，从新梳理下
 * 需要先序遍历，如果不对交换节点，好像只有知道先序遍历和结果的关系才比较好做题
 * 
 * 没有根据dfs 的方式思考，只考虑当前节点的情况，如果当前节点相等，就尝试所有的可能情况，直接递归，不考虑情况是否符合，
 * [971] 翻转二叉树以匹配先序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private int index = 0;
    private ArrayList list = new ArrayList<Integer>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if(dfs(root, voyage)){
            return list;
        };
        list.clear();
        list.add(-1);
        return list;

    }

    public boolean dfs(TreeNode root, int[] voyage) {

        if (root == null ) {
            return true;
        }else if(index == voyage.length){
            return false;
        }
        if (root.val != voyage[index]) {
            return false;
        }
        index++;
        if (dfs(root.left, voyage) && dfs(root.right, voyage)) {
            return true;
        } else if (dfs(root.right, voyage) && dfs(root.left, voyage)) {
            list.add(root.val);
            return true;
        }
        return false;
    }
}
// @lc code=end
