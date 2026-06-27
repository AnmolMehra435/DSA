//Algorithm

//Algorithm: Median of Two Sorted Arrays (Binary Search on Partition)
//
//1. Always perform binary search on the smaller array.
//   - If nums1.length > nums2.length, swap the arrays.
//
//2. Let:
//   m = nums1.length
//   n = nums2.length
//
//3. Initialize:
//   low = 0
//   high = m
//
//4. While low <= high:
//   - Find partition in first array:
//     mid1 = (low + high) / 2
//
//   - Calculate partition in second array:
//     mid2 = (m + n + 1) / 2 - mid1
//
//5. Find the boundary elements around both partitions:
//
//   l1 = (mid1 == 0) ? -∞ : nums1[mid1 - 1]
//   r1 = (mid1 == m) ? +∞ : nums1[mid1]
//
//   l2 = (mid2 == 0) ? -∞ : nums2[mid2 - 1]
//   r2 = (mid2 == n) ? +∞ : nums2[mid2]
//
//6. Check if the partition is valid:
//
//   if (l1 <= r2 && l2 <= r1)
//
//7. If the partition is valid:
//   - If total number of elements is odd:
//       return max(l1, l2)
//
//   - Otherwise:
//       return (max(l1, l2) + min(r1, r2)) / 2.0
//
//8. If l1 > r2:
//      Move left:
//      high = mid1 - 1
//
//9. Otherwise:
//      Move right:
//      low = mid1 + 1
//
//Time Complexity: O(log(min(m, n)))
//Space Complexity: O(1)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while(low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            int l1 = (mid1 == 0)? Integer.MIN_VALUE: nums1[mid1 - 1];
            int r1 = (mid1 == m)? Integer.MAX_VALUE: nums1[mid1];

            int l2 = (mid2 == 0)? Integer.MIN_VALUE: nums2[mid2 - 1];
            int r2 = (mid2 == n)? Integer.MAX_VALUE: nums2[mid2];

            if(l1 <= r2 && l2 <= r1){
                if((m + n) % 2 != 0){
                    return Math.max(l1, l2);
                }else{
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }
        return 0.0;
    }
}