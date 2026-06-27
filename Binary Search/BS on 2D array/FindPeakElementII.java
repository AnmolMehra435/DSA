//Algorithm

//
//1. Perform Binary Search on columns.
//      low = 0, high = n - 1
//
//2. For each middle column:
//      - Find the row having the maximum element in that column.
//
//3. Compare this maximum element with its left and right neighbors.
//      - If it is greater than both, return its position.
//      - If left neighbor is greater, search in the left half.
//      - Otherwise, search in the right half.
//
//4. Repeat until a peak is found.
//
//Time Complexity: O(m * log n)
//Space Complexity: O(1)

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int maxRow = 0;
            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < n - 1) ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > left &&
                    mat[maxRow][mid] > right) {

                return new int[]{maxRow, mid};
            }
            else if (left > mat[maxRow][mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}