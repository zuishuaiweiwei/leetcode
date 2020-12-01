
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] pondSizes(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        if(n==0 || m == 0){
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0 ; i< n; i++){
            for (int j = 0 ; j < m ; j ++){
                if(land[i][j] == 0){
                    list.add(dfs(land,i,j));
                }
            }
        }
//        return list.stream().toArray(Integer[]::new);
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(ints);
        return  ints;
    }
    public int dfs(int[][] land, int i ,int j ){
        if( i >= land.length || j >= land[0].length || i < 0 || j < 0 || land [i][j] != 0 ){
            return 0;
        }
        int res = 1;
        land[i][j] = -1;
        res += dfs(land,i+1,j-1);
        res += dfs(land,i+1,j);
        res += dfs(land,i+1,j+1);
        res += dfs(land,i,j-1);
        res += dfs(land,i,j+1);
        res += dfs(land,i-1,j-1);
        res += dfs(land,i-1,j);
        res += dfs(land,i-1,j+1);
        return res;
    }
}