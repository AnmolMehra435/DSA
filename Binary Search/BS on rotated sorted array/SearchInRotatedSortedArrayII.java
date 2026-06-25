//Find element in rotated sorted array containing duplicates

//Algorithm
//
//1. Find mid and check if it is the target.
//2. If low, mid, and high all have the same value, shrink the search space by doing low++ and high--
//   because you cannot determine the sorted half.
//3. Otherwise, identify the sorted half:
//   - If nums[low] <= nums[mid], the left half is sorted.
//   - Else, the right half is sorted.
//4. Check whether the target lies in the sorted half.
//5. If yes, search in that half; otherwise, search in the other half.
//6. Repeat until the target is found or the search space becomes empty.
//
//Trick:
//Duplicates can hide the pivot. Whenever nums[low] == nums[mid] == nums[high],
//remove the duplicates first by moving both pointers inward.


class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low<=high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return true;
            }

            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}