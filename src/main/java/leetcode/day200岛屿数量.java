package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class day200岛屿数量 {
 int a=0;
    public int numIslands(char[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    // 题目限制只有一个岛屿，计算一个即可
                    dfs(grid, r, c);
                    a+=1;
                }
            }
        }
        return a;

    }
    void dfs(char[][] grid, int r, int c) {
        // 判断 base case
        if (!inArea(grid, r, c)) {
            return;
        }
        // 如果这个格子不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2'; // 将格子标记为「已遍历过」

        // 访问上、下、左、右四个相邻结点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 判断坐标 (r, c) 是否在网格中
    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

    //方法二，广度优先，类似二叉树广度优先遍历，此处可看做四叉树
    public int numIslands2(char[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    // 题目限制只有一个岛屿，计算一个即可
                    a+=1;
                    bfs(grid, r, c);
                }
            }
        }
        return a;
    }

    private void bfs(char[][] grid, int i, int j) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[] { i, j });
        while (!list.isEmpty()){
            int[] poll = list.poll();
            int i1 = poll[0];
            int i2 = poll[1];
            grid[i1][i2] = '0';
            if(inArea(grid, i1+1, i2)&&grid[i1+1][i2]=='1') {
                list.add(new int[] { i1 + 1, i2 });
                grid[i1 + 1][i2]='0';
            }
            if(inArea(grid, i1-1, i2)&&grid[i1-1][i2]=='1') {
                list.add(new int[] { i1 - 1, i2 });
                grid[i1 - 1][i2]='0';
            }
            if(inArea(grid, i1, i2+1)&&grid[i1][i2+1]=='1') {
                list.add(new int[] { i1, i2 + 1 });
                grid[i1 ][i2+1]='0';
            }
            if(inArea(grid, i1, i2-1)&&grid[i1][i2-1]=='1') {
                list.add(new int[] { i1 , i2-1 });
                grid[i1][i2-1]='0';
            }
        }


    }

    public static void main(String[] args) {
        day200岛屿数量 day200 = new day200岛屿数量();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int i = day200.numIslands(grid);
        System.out.println(i);
    }

}
