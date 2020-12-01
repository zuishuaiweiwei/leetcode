import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=721 lang=java
 * 不是树形结构，初步想到的办法都没有需要递归的地方，什么方法需要用到 dfs，将结构变成树形结构也不行，没有共同节点，应该不是用树形结构解题，直观的方法就是用一个结构保存遍历过的邮箱，如果已存在，那么将这个新邮箱的地址添加到已存在的结构，这样应该是可以的，就是不同的账号名称可能相同，应该用什么样的结构来保存数据，也是一个问题。
 * 如果配合n个树结构怎么样？有两个结构，n 个 树，一个 map 保存 邮箱 ，名称作为根节点，如果邮箱已存在，那么将构建名称数，存在就添加（应该是一个map，防止重复）。不过没有dfs的使用。先实现这个方法吧
 * 想的方法比较麻烦，感觉离答案很远了
 * 没想到差的不远，没有很巧妙的技巧
 * 刚才想的时候忘了map的去重性。如果 email为key ，那么重复名称一定相等,map不会更新，遍历一遍后map里就是答案应该出现的email数量，然后想办法处理name ，这样会保存不同人的不同emil 和name 无法区分是不是一个人，需要另外的东西判断，那就不保存name ，保存name的索引，这样就要考虑覆盖的问题，如果name 存在，一个数组 arr[准备覆盖的val] = 覆盖的val 并且 arr[ 覆盖的 val] = 失效，那么第二次遍历的时候可以知道这个位置是需要合并的
 * [721] 账户合并
 */

// @lc code=start
class Solution {

    private HashMap<String, Integer> email2NameIndex = new HashMap<>();
    private List<List<String>> ret = new ArrayList<>();

    public List<List<String>> accountsMerge(final List<List<String>> accounts) {
        int[] par = new int[accounts.size()];
        Arrays.fill(par, -1);
        for (int j = 0; j < accounts.size(); j++) {
            List<String> list = accounts.get(j);
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                if (email2NameIndex.containsKey(email)) {
                    par[email2NameIndex.get(email)] = j;
                    par[j] = 0;
                }
                email2NameIndex.put(email, j);
            }
        }
        for (int i = 0; i < par.length; i++) {
            if (par[i] != -1) {
                meger(accounts, par[i], i);
            }
        }
    }

    public void meger(List<List<String>> accounts,int a,int b){
        for(Entry<String, Integer> entry :email2NameIndex.entrySet()){
            int val = entry.getValue();
            String key = entry.getKey();
            if(val==a|| val == b){
            }



        }
    }

}
// @lc code=end
