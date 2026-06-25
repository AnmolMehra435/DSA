//ALgorithm

//1. Initialize:
//   low = 0, high = n - 1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//   - If nums[mid] == target, return mid
//   - If nums[mid] < target, search right half:
//       low = mid + 1
//   - Else, search left half:
//       high = mid - 1
//
//3. If target is not found, return -1

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}