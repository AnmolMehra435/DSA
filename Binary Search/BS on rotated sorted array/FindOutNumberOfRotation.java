//Find Number of Rotations in a Rotated Sorted Array
//
//1. Use Binary Search with low = 0 and high = n - 1.
//2. Find mid in each iteration.
//3. Compare arr[mid] with arr[high]:
//   - If arr[mid] <= arr[high], the minimum element (pivot) lies in the left half including mid, so move high = mid.
//   - If arr[mid] > arr[high], the minimum element lies in the right half, so move low = mid + 1.
//4. Continue until low == high.
//5. The index of the minimum element gives the number of rotations.
//
//Trick:
//The minimum element is the pivot point of rotation.
//- arr[mid] > arr[high]  → pivot is on the right.
//- arr[mid] <= arr[high] → pivot is on the left (including mid).
//
//Number of rotations = index of the minimum element.

class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int low = 0;
        int high = arr.length - 1;
        while(low<high){
            int mid = low + (high - low) / 2;

            if(arr[mid] <= arr[high]){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}