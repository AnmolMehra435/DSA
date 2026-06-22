//Algorithm
//   1 Keep a window [left, right].
//   2 Expand right and add elements to the current sum.
//   3 While the sum is greater than k, shrink the window from the left.
//   4 Whenever the sum becomes k, update the answer.


class Solution {
    public int longestSubarray(int[] arr, int k) {

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {

            sum += arr[right];

            while (sum > k) {
                sum -= arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}