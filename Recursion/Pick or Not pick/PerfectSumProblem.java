//Algorithm:
//
//1. Start recursion from index 0 with currentSum = 0.
//2. If currentSum exceeds the target, return 0.
//3. If all elements are processed:
//      - Return 1 if currentSum == target.
//      - Otherwise return 0.
//4. For each element, make two recursive calls:
//      - Include the current element.
//      - Exclude the current element.
//5. Return the sum of both recursive calls as the total number of valid subsets.

class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        return solve(nums, target, 0, 0);
    }

    public int solve(int[] nums, int target, int currentSum, int index){
        if(index == nums.length){
            return currentSum == target? 1 : 0;
        }

        if(currentSum > target){
            return 0;
        }

        int take = solve(nums, target, currentSum + nums[index], index + 1);

        int notTake = solve(nums, target, currentSum, index + 1);

        return take + notTake;
    }
}