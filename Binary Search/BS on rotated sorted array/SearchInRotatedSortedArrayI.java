//Find Target in Rotated Sorted Array (LC 33)
//
//1. Perform normal Binary Search.
//2. At every iteration, one half will always be sorted.
//
//while(low <= high):
//    mid = low + (high - low) / 2
//
//    if(nums[mid] == target)
//        return mid
//
//    // Left half sorted
//    if(nums[low] <= nums[mid]) {
//
//        // Target lies in left half
//        if(target >= nums[low] && target < nums[mid])
//            high = mid - 1;
//        else
//            low = mid + 1;
//    }
//
//    // Right half sorted
//    else {
//
//        // Target lies in right half
//        if(target > nums[mid] && target <= nums[high])
//            low = mid + 1;
//        else
//            high = mid - 1;
//    }
//
//return -1

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
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

        return -1;
    }
}