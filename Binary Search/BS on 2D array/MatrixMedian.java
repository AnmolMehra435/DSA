//Algorithm

//Algorithm:
//
//1. Find the minimum element (first element of each row)
//   and maximum element (last element of each row).
//
//2. Perform Binary Search on the range [min, max].
//
//3. For each middle value (mid):
//      - Count the number of elements <= mid in the matrix.
//      - Use Upper Bound on every row to get this count.
//
//4. If count <= (R * C) / 2:
//      search in the right half.
//   Else:
//      search in the left half.
//
//5. Continue until the search space is exhausted.
//
//6. The final value of low is the median.
//
//Time Complexity: O(log(max-min) * R * log C)
//Space Complexity: O(1)

class Solution {
    int median(int matrix[][]) {

        int R = matrix.length;
        int C = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][C - 1]);
        }

        int req = (R * C) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;

            for (int i = 0; i < R; i++) {
                count += upperBound(matrix[i], mid);
            }

            if (count <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}