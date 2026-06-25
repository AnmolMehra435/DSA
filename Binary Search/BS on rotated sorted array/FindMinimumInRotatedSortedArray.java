//Find Minimum in Rotated Sorted Array (LC 153)
//
//1. Use Binary Search with low = 0 and high = n - 1.
//2. Find mid in each iteration.
//3. Compare nums[mid] with nums[high]:
//   - If nums[mid] <= nums[high], the minimum lies in the left half (including mid), so move high = mid.
//   - If nums[mid] > nums[high], the minimum lies in the right half, so move low = mid + 1.
//4. Continue until low == high.
//5. The element at index low (or high) is the minimum.
//
//Trick:
//Compare mid with high.
//- nums[mid] > nums[high]  → minimum is on the right.
//- nums[mid] <= nums[high] → minimum is on the left (including mid).
//
//The unsorted half always contains the minimum element.

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(nums[mid] <= nums[high]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return nums[low];
    }
}