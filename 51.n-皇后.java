import java.util.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start

class Solution {
    private List<List<String>> res = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        String[][] arr = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ".";
            }
        }
        process(arr, 0);
        return res;
    }

    public void process(String[][] arr, int h) {
        if (h == arr.length) {
            saveRes(arr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[h][i] = "Q";
            if (verify(arr, h, i)) {
                process(arr, h+1);
            }
            arr[h][i] = ".";
        }
    }

    public boolean verify(String[][] arr,int row ,int col) {
        for(int i = 0 ; i < row; i++){
            if(arr[i][col].equals("Q")){
                return false;
            }
        }
        for(int i = row-1 ,j = col -1; i>=0 && j >=0 ; i--,j--){
            if(arr[i][j].equals("Q")){
                return false;
            }
        }
        for(int i = row - 1, j = col + 1;i>=0&& j < arr.length; i--,j++){
            if(arr[i][j].equals("Q")){
                return false;
            }
        }
        return true;

    }

    public void saveRes(String[][] arr) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder str = new StringBuilder("");
            for (int j = 0; j < arr[0].length; j++) {
                str.append(arr[i][j]);
            }
            list.add(str.toString());
        }
        res.add(list);
    }
}

// @lc code=end
