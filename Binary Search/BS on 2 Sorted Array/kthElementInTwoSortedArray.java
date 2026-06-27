//Algorithm: K-th Element of Two Sorted Arrays
//
//1. Always perform binary search on the smaller array.
//   - If a.length > b.length, swap the arrays.
//
//2. Initialize:
//   m = a.length
//   n = b.length
//
//   low = max(0, k - n)
//   high = min(k, m)
//
//3. While low <= high:
//
//   - mid1 = (low + high) / 2
//   - mid2 = k - mid1
//
//4. Find boundary elements around both partitions:
//
//   l1 = (mid1 == 0) ? -∞ : a[mid1 - 1]
//   r1 = (mid1 == m) ? +∞ : a[mid1]
//
//   l2 = (mid2 == 0) ? -∞ : b[mid2 - 1]
//   r2 = (mid2 == n) ? +∞ : b[mid2]
//
//5. If the partition is valid:
//
//      l1 <= r2 && l2 <= r1
//
//   return max(l1, l2)
//
//6. If l1 > r2:
//      Move left:
//      high = mid1 - 1
//
//7. Otherwise:
//      Move right:
//      low = mid1 + 1
//
//Time Complexity: O(log(min(m, n)))
//Space Complexity: O(1)

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        if(a.length > b.length){
            return kthElement(b, a, k);
        }

        int m = a.length;
        int n = b.length;

        int low = Math.max(0, k-n);
        int high = Math.min(k , m);

        int total = m + n;

        while(low<=high){
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE: a[mid1 - 1];
            int r1 = (mid1 == m) ? Integer.MAX_VALUE: a[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE: b[mid2 - 1];
            int r2 = (mid2 == n)? Integer.MAX_VALUE: b[mid2];

            if(l1<=r2 && l2<=r1){
                return Math.max(l1, l2);
            }else if(l1>r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
        }

        return 0;
    }
}