/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public static int reverse(int x) {
        boolean b = false;
        Long l = Long.valueOf(x);
        if(l == 0){
            return 0;
        }

        if(l < 0){
            b = true;
        }
        l = Math.abs(l);
        char [] arr = l.toString().toCharArray();
        int zero = 0;
        int initLen = arr.length;
        for(int i = arr.length -1 ;i >= arr.length /2 ; i-- ){
            int j = arr.length -1 -i;
            if(zero == 0 && arr[i]=='0'){
                arr[i] =  arr[j];
                arr[j] = '#';
                initLen -=1;
            }else{
                zero = 1;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        char[] res = new char[initLen];

        int j = 0;
        for(int i = 0 ;i < res.length ; i++ ){
            if( arr[j] == '#'){
                j++;
                i--;
                continue;
            }
            res[i] = arr[j++];
        }

        if(Long.valueOf(new String(res)) > Integer.MAX_VALUE || Long.valueOf(new String(res)) < Integer.MIN_VALUE){
            return 0;
        }
        int ret = b ? 0 - Integer.valueOf(new String(res)).intValue():Integer.valueOf(new String(res)).intValue();
        return ret;
    }

}
// @lc code=end

