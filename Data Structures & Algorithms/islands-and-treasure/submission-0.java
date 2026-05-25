class Solution {
    private static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int inf = 2147483647;
    private static int ROW;
    private static int COL;

    public void islandsAndTreasure(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == inf) {
                    grid[i][j] = bfs(grid, i, j);
                }
            }
        }
    }

    private int bfs(int[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        int steps = 0;
        boolean[][] visited = new boolean[ROW][COL];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                int r = curr[0];
                int c = curr[1];
                if (grid[r][c] == 0) {
                    return steps;
                }
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (0 <= nr && 0 <= nc && nr < ROW && nc < COL && 
                    grid[nr][nc] != -1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            steps++;
        }
        return inf;
    }
}
