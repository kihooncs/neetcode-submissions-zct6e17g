class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, visited, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int[][] visited, String word, int i, int row, int col) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(i) || visited[row][col] == 1) {
            return false;
        }

        visited[row][col] = 1;
        boolean res = backtrack(board, visited, word, i + 1, row - 1, col) ||
                      backtrack(board, visited, word, i + 1, row + 1, col) ||
                      backtrack(board, visited, word, i + 1, row, col - 1) ||
                      backtrack(board, visited, word, i + 1, row, col + 1);
        visited[row][col] = 0;
        return res;
    }
}