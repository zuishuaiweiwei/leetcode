import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public String up(String str, int i) {
        char[] ch = str.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] = (char) (ch[i] + 1);
        }
        return new String(ch);
    }

    public String down(String str, int i) {
        char[] ch = str.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] = (char) (ch[i] - 1);
        }
        return new String(ch);
    }

    public boolean isDie(String str, String[] deadends) {
        for (String string : deadends) {
            if (string.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int openLock(String[] deadends, String target) {
        String res = "0000";
        LinkedList<String> list = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        list.offer(res);
        int ret = 0;
        for (String string : deadends) {
            if(string.equals(res) && !target.equals(res)){
                return -1;
            }
            set.add(string);
        }
        while (!list.isEmpty()) {
            int sz = list.size();
            for (int i = 0; i < sz; i++) {

                String temp = list.poll();
                if (temp.equals(target)) {
                    return ret;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(temp, j);
                    if (!set.contains(up)) {
                        list.offer(up);
                        set.add(up);
                    }
                    String down = down(temp, j);
                    if (!set.contains(down)) {
                        list.offer(down);
                        set.add(down);
                    }
                }
            }
            ret++;
        }
        return -1;
    }

}
// @lc code=end
