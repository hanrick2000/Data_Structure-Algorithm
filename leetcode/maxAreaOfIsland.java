package leetcode;

public class maxAreaOfIsland {
}
class numIslands{
    public int maxAreaOfIsland(char[][] grid) {
        int cnt = 0;
        if (grid.length == 0){
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }else {
            return;
        }
    }


}
