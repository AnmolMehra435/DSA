//Algorithm

//Algorithm:
//
//1. Treat the entire matrix as a single sorted 1D array of size m × n.
//2. Initialize low = 0 and high = m*n - 1.
//3. Perform binary search:
//      - Find mid = low + (high - low) / 2.
//      - Convert mid to 2D indices:
//            row = mid / n
//            col = mid % n
//      - If matrix[row][col] == target, return true.
//      - If matrix[row][col] < target, search right half.
//      - Otherwise, search left half.
//4. If the target is not found, return false.
//
//Time Complexity: O(log(m*n))
//Space Complexity: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}