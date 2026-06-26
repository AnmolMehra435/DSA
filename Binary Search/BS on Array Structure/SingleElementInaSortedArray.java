//ALGORITHM
//
// 1. Set low = 0, high = n - 1.
//
//2. While low < high:
//      mid = low + (high - low)/2
//
//      If:
//         (mid is even and arr[mid] == arr[mid+1])
//         OR
//         (mid is odd and arr[mid] == arr[mid-1])
//
//             low = mid + 1
//
//      Else
//             high = mid
//
//3. When loop ends, low == high.
//   Return arr[low].


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(mid % 2 == 0 && nums[mid] == nums[mid+1] ||
                    mid % 2 != 0 && nums[mid] == nums[mid-1]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}