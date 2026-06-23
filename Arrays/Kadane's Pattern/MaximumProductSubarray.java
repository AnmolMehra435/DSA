//Algorithm

//1. Initialize:
//   maxProd = arr[0]
//   minProd = arr[0]
//   ans = arr[0]
//
//2. Traverse from i = 1 to n-1:
//
//   a) If arr[i] is negative:
//         swap(maxProd, minProd)
//
//   b) Update:
//         maxProd = max(arr[i], maxProd * arr[i])
//         minProd = min(arr[i], minProd * arr[i])
//
//   c) Update answer:
//         ans = max(ans, maxProd)
//
//3. Return ans.

class Solution {
    public int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);

            ans = Math.max(ans, maxProd);
        }

        return ans;
    }
}