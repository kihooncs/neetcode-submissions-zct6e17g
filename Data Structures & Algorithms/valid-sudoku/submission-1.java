class Solution {
    public boolean isValidSudoku(char[][] board) {

        // check rows
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char curr = board[row][i];
                if (curr != '.') {
                    if (seen.contains(curr)) {
                        return false;
                    } else {
                        seen.add(curr);
                    }
                }
            }
        }

        // check columns
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char curr = board[i][col];
                if (curr != '.') {
                    if (seen.contains(curr)) {
                        return false;
                    } else {
                        seen.add(curr);
                    }
                }
            }
        }

        // check square
        for (int sq = 0; sq < 9; sq++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char curr = board[(sq / 3) * 3 + i][(sq % 3) * 3 + j];
                    if (curr != '.') {
                        if (seen.contains(curr)) {
                            return false;
                        } else {
                            seen.add(curr);
                        }
                    }
                }
            }
        }
        return true;
    }
}
