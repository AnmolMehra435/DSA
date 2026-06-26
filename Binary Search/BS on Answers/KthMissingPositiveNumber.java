//Algorithm

//1. Binary search on the array.
//
//2. For each mid:
//      missing = arr[mid] - (mid + 1)
//
//3. If missing < k:
//      search right.
//
//4. Otherwise:
//      search left.
//
//5. After the loop, low represents the number of elements
//   present before the kth missing number.
//
//6. Return low + k.

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            int missing = arr[mid] - (mid + 1);

            if(missing < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low + k;
    }
}