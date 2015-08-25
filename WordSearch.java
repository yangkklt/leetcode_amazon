public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (m * n < word.length()) {
            return false;
        }
        boolean[][] visited = new boolean[m][n];
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canFind(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean canFind(char[][] board, String word, boolean[][] visited, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(pos)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = canFind(board, word, visited, i + 1, j, pos + 1) || canFind(board, word, visited, i - 1, j, pos + 1) || canFind(board, word, visited, i, j + 1, pos + 1) || canFind(board, word, visited, i, j - 1, pos + 1);
        visited[i][j] = false;
        return res;
    }
}