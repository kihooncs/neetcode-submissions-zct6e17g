class Solution {
    private static final int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    res++;
                    bfs(grid, row, col);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        grid[row][col] = '0';
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int currR = curr[0];
            int currC = curr[1];

            for (int[] dir : direction) {
                int newR = currR + dir[0];
                int newC = currC + dir[1];

                if (newR < grid.length && newC < grid[0].length && 0 <= newR && 0 <= newC && grid[newR][newC] == '1') {
                    grid[newR][newC] = '0';
                    q.add(new int[]{newR, newC});
                }
            }
        }
    }
}
