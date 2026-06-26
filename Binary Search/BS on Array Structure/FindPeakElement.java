//ALGORITHM

//1. Set low = 0, high = n - 1.
//
//2. While low < high:
//
//       mid = low + (high - low)/2
//
//       If nums[mid] < nums[mid + 1]
//              low = mid + 1
//       Else
//              high = mid
//
//3. When loop ends, low == high.
//
//4. Return low.


class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right - left) / 3;

            if(nums[mid] <= nums[mid + 1]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}