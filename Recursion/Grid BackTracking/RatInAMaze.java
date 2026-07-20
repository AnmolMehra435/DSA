//1. If the starting cell is blocked, return an empty list.
//2. Start DFS from cell (0,0).
//
//DFS(row, col):
//    • If cell is out of bounds or blocked, return.
//    • If destination is reached, add the current path to the answer.
//    • Mark the current cell as visited.
//    • Move in the order:
//        Down (D)
//        Left (L)
//        Right (R)
//        Up (U)
//      Append the direction before recursion and remove it after returning.
//    • Unmark the current cell (backtrack).
//
//3. Return all collected paths.


class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        if(maze[0][0] == 0){
            return result;
        }

        dfs(0, 0, result, maze, curr);


        return result;
    }

    private void dfs(int row, int col, ArrayList<String> result, int[][] maze,
                     StringBuilder curr){

        if(row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] != 1){
            return;
        }

        if(row == maze.length -1 && col == maze[0].length - 1){
            result.add(curr.toString());
            return;
        }


        maze[row][col] = 0;

        curr.append('D');
        dfs(row + 1, col, result, maze, curr);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('L');
        dfs(row, col - 1, result, maze, curr);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('R');
        dfs(row, col + 1, result, maze, curr);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('U');
        dfs(row - 1, col, result, maze, curr);
        curr.deleteCharAt(curr.length() - 1);




        maze[row][col] = 1;
    }
}