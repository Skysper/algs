package com.skysper.leetcode;

/**
 * @author wupengfei
 * @date 2022-03-22 23:53
 */
public class IslandCount_200 {


    public int numIslands(char[][] grid) {
        int len = grid.length;
        int col = grid[0].length;

        int total = 0;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    total++;
                    process(grid, i, j);
                }
            }
        }

        return total;
    }

    /**
     * 1  1
     * 1  1
     * 1111
     * @param grid
     * @param i
     * @param j
     */
    private void process(char[][] grid, int i, int j) {
        if(i < 0 || i >=grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if(grid[i][j] =='1') {
            grid[i][j] = '2';
            process(grid, i-1, j);
            process(grid, i+1, j);
            process(grid,i, j+1);
            process(grid, i, j-1);
        }
    }

}
