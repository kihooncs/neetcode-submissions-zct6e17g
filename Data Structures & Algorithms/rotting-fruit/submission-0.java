class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int row = grid.length;
        int col = grid[0].length;
        int time = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = q.remove();
                for (int[] dir : directions) {
                    int nr = rotten[0] + dir[0];
                    int nc = rotten[1] + dir[1];
                    if (Math.min(nr, nc) >= 0 && nr < row && nc < col && 
                    grid[nr][nc] == 1) {
                        fresh--;
                        grid[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            time++;
        }

        return fresh > 0 ? -1 : time;
    }
}
