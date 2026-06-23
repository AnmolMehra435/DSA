//Algorithm (Kadane's Algorithm)

//1. Initialize:
//     currentSum = 0
//     maxSum = Integer.MIN_VALUE
//2. Traverse the array:
//     Add current element to currentSum.
//3. Update maxSum = max(maxSum, currentSum).
//      If currentSum < 0, reset currentSum = 0.
//4. After traversal, maxSum is the answer.

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int current = 0;

        for(int i = 0; i<nums.length; i++){
            current += nums[i];

            max = Math.max(max, current);
            if(current < 0){
                current = 0;
            }
        }
        return max;
    }
}