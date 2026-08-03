//Algorithm:
//
//1. Traverse the Sudoku board row by row and column by column.
//
//2. If the current cell is empty ('.'):
//   a. Try placing digits '1' to '9'.
//   b. For each digit, check if it is safe:
//      - The digit is not present in the same row.
//      - The digit is not present in the same column.
//      - The digit is not present in the corresponding 3×3 subgrid.
//   c. If safe:
//      - Place the digit.
//      - Recursively solve the remaining board.
//      - If recursion returns true, the puzzle is solved.
//      - Otherwise, remove the digit (backtrack).
//
//3. If no digit can be placed in the current empty cell, return false.
//
//4. If all cells are filled (no empty cell is found), return true.
//
//Safety Check:
//- Scan the entire row.
//- Scan the entire column.
//- Scan the corresponding 3×3 subgrid.
//- If the digit is absent in all three, the position is safe.
//
//Backtracking:
//Place Digit → Recur → If Failed → Remove Digit → Try Next Digit

class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){

                if(board[i][j] == '.'){
                    for(char digit = '1'; digit<='9'; digit++){

                        if(isSafe(board, i, j, digit)){
                            board[i][j] = digit;
                            if(backtrack(board)){
                                return true;
                            }

                            board[i][j] = '.';
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char digit){
        for(int i =0; i<9; i++){
            if(board[row][i] == digit){
                return false;
            }
        }

        for(int i = 0; i<9; i++){
            if(board[i][col] == digit){
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int i = startRow; i<=startRow + 2; i++){
            for(int j = startCol; j<=startCol + 2; j++){
                if(board[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
}