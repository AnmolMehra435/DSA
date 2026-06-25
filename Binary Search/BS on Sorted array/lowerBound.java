//Algorithm:
//
//1. Initialize:
//   low = 0, high = n - 1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//   - If arr[mid] < target:
//       low = mid + 1
//   - Else:
//       high = mid - 1
//
//3. Return low (index of the first element >= target)

class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int low = 0;
        int high = arr.length -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
