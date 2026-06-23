//Algorithm

//1. Initialize:
//   currSum = 0, maxSum = -1
//   start = 0
//   bestStart = -1, bestEnd = -1
//
//2. Traverse the array:
//   a) If arr[i] >= 0:
//        Add arr[i] to currSum.
//
//   b) If arr[i] < 0:
//        - Current non-negative subarray ends here.
//        - Compare current subarray with the best one:
//            • Update if currSum > maxSum.
//            • If sums are equal, update if current length is greater.
//        - Reset:
//            currSum = 0
//            start = i + 1
//
//3. After traversal, compare the last subarray
//   (because the array may end with non-negative elements).
//
//4. If no valid subarray was found (bestStart == -1),
//   return [-1].
//
//5. Otherwise, return elements from bestStart to bestEnd.

class Solution {
    public ArrayList<Integer> findSubarray(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();

        long maxSum = -1;
        long currSum = 0;

        int start = 0;
        int bestStart = -1;
        int bestEnd = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 0) {
                currSum += arr[i];
            } else {
                if (start <= i - 1) {

                    int currLen = i - start;
                    int bestLen = (bestStart == -1)
                            ? 0
                            : bestEnd - bestStart + 1;

                    if (currSum > maxSum ||
                            (currSum == maxSum && currLen > bestLen)) {

                        maxSum = currSum;
                        bestStart = start;
                        bestEnd = i - 1;
                    }
                }

                currSum = 0;
                start = i + 1;
            }
        }
        if (start < arr.length) {

            int currLen = arr.length - start;
            int bestLen = (bestStart == -1)
                    ? 0
                    : bestEnd - bestStart + 1;

            if (currSum > maxSum ||
                    (currSum == maxSum && currLen > bestLen)) {

                maxSum = currSum;
                bestStart = start;
                bestEnd = arr.length - 1;
            }
        }
        if (bestStart == -1) {
            ans.add(-1);
            return ans;
        }

        for (int i = bestStart; i <= bestEnd; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }
}