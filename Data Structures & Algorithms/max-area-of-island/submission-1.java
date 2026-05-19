class Solution {
    private static final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = 0;
        int res = 1;

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int[] dir : directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (0 <= newRow && 0 <= newCol && newRow < grid.length && newCol < grid[0].length &&
                grid[newRow][newCol] == 1) {
                    res++;
                    grid[newRow][newCol] = 0;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return res;
    }
}
