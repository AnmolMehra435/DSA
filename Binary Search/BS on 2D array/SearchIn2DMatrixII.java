//Algorithm:
//
//1. Start from the top-right corner of the matrix.
//      i = 0, j = n - 1
//
//2. While i < m and j >= 0:
//      - If matrix[i][j] == target, return true.
//      - If matrix[i][j] < target, move down (i++).
//      - If matrix[i][j] > target, move left (j--).
//
//3. If the target is not found, return false.
//
//Time Complexity: O(m + n)
//Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while(i < m && j >= 0){
            int element = matrix[i][j];

            if(element == target){
                return true;
            }else if(element < target){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
}