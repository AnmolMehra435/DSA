//Algorithm

//Algorithm:
//
//1. Initialize:
//   low = 0, high = n - 1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//   - If nums[mid] == target:
//       return mid
//   - If nums[mid] < target:
//       low = mid + 1
//   - Else:
//       high = mid - 1
//
//3. If target is not found, return low
//   (the index where target should be inserted)


class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low;
    }
}