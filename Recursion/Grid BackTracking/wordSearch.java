//1. Traverse every cell of the board.
//2. Start DFS from each cell.
//
//DFS(row, col, idx):
//    • If idx == word.length(), return true.
//    • If out of bounds OR character doesn't match, return false.
//    • Mark current cell as visited ('#').
//    • Recursively search in:
//        - Up
//        - Down
//        - Left
//        - Right
//    • Restore the original character (backtracking).
//    • Return true if any direction finds the word, else false.
//
//3. If any DFS returns true, return true.
//4. If all starting cells fail, return false.

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(dfs(i, j, board, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, char[][] board, String word, int idx){
        if(idx == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found =
                dfs(row+1, col, board, word, idx + 1) ||
                        dfs(row-1, col, board, word, idx + 1) ||
                        dfs(row, col + 1, board, word, idx + 1)||
                        dfs(row, col - 1, board, word, idx + 1);

        board[row][col] = temp;

        return found;
    }
}