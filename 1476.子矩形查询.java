/*
 * @lc app=leetcode.cn id=1476 lang=java
 *
 * [1476] 子矩形查询
 */

// @lc code=start
class SubrectangleQueries {

    private int[][] rectangle;
    public class Temp {
        public int[] p1 = new int[2];
        public int[] p2 = new int[2];
        public int value;

        public Temp(int row1, int col1, int row2, int col2, int newValue) {
            this.p1[0] = row1;
            this.p2[0] = row2;
            this.p1[1] = col1;
            this.p2[1] = col2;
            this.value = newValue;
        }
    }

    private ArrayList<Temp> updateList = new ArrayList();

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        Temp temp = new Temp(row1, col1, row2, col2, newValue);
        updateList.add(temp);
    }

    public int getValue(int row, int col) {
        for (int i = updateList.size() - 1; i >= 0; i--) {
            Temp temp = updateList.get(i);
            if (row >= temp.p1[0] && col >= temp.p1[1] && row <= temp.p2[0] && col <= temp.p2[1]) {
                return temp.value;
            }
        }

        return rectangle[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
// @lc code=end

