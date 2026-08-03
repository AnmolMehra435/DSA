//1. Create an n × n board filled with '.'.
//
//2. Start placing queens row by row.
//
//3. For each column in the current row:
//   - Check if placing a queen is safe.
//   - If safe:
//       • Place 'Q'.
//       • Recur for the next row.
//       • Backtrack by replacing 'Q' with '.'.
//
//4. If all rows are filled:
//   - Convert the board into a List<String>.
//   - Add it to the result.
//
//Safety Check:
//- Check the same column above.
//- Check the upper-left diagonal.
//- Check the upper-right diagonal.
//- If no queen is found, the position is safe.
//
//Backtracking:
//- Place → Explore → Remove (Undo)

class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board){
            Arrays.fill(row, '.');
        }

        backtrack(board, 0);
        return result;
    }

    private void backtrack(char[][] board, int row){
        if(row == board.length){
            result.add(convert(board));
            return;
        }

        for(int i = 0; i<board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                backtrack(board, row+1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col){
        for(int i = 0; i<=col; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }

        for(int i = 0; i<=row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col -1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    private List<String> convert(char[][] board){
        List<String> curr = new ArrayList<>();
        for(char[] row: board){
            curr.add(new String(row));
        }

        return curr;
    }
}