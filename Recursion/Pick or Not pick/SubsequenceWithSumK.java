//THIS IS NOT THE OPTIMAL APPROACH TO DO THIS

//Algorithm:
//
//1. Start recursion from index 0 with currentSum = 0.
//2. If currentSum equals K, return true.
//3. If all elements are processed, return false.
//4. For each element, make two recursive calls:
//      - Include the current element in the sum.
//      - Exclude the current element.
//5. Return true if either recursive call returns true; otherwise return false.

class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        return solve(arr, k, 0, 0);
    }

    public boolean solve(int[] arr, int k, int currentSum, int index){
        if(currentSum == k){
            return true;
        }
        if(index == arr.length){
            return false;
        }

        return solve(arr, k, currentSum + arr[index], index + 1) || solve(arr, k, currentSum, index + 1);
    }
}