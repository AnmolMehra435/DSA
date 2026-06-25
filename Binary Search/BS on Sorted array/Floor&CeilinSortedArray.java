//Floor in Sorted Array (Largest element <= x)
//
//1. Initialize:
//   low = 0, high = n - 1
//   ans = -1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//
//   - If arr[mid] <= x:
//       ans = mid
//       low = mid + 1      // Search for a larger valid floor
//
//   - Else:
//       high = mid - 1
//
//3. Return ans
//
//
//Ceil in Sorted Array (Smallest element >= x)
//
//1. Initialize:
//   low = 0, high = n - 1
//   ans = -1
//
//2. While (low <= high):
//   - mid = low + (high - low) / 2
//
//   - If arr[mid] >= x:
//       ans = mid
//       high = mid - 1     // Search for a smaller valid ceil
//
//   - Else:
//       low = mid + 1
//
//3. Return ans

//Floor in sorted array (arr[i] <= x)
class Solution {
    public int findFloor(int[] arr, int x) {
        // code here
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] <= x){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }
}


//Ceil in sorted array (arr[i] >= x)

class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
