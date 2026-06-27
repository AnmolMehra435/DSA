//Algorithm

//1. Set:
//      low = maximum element in array
//      high = sum of all elements
//      ans = -1
//
//2. While low <= high:
//      mid = low + (high - low) / 2
//
//      If array can be split into at most k
//      subarrays with maximum subarray sum = mid:
//            ans = mid
//            high = mid - 1      // try smaller maximum sum
//      Else:
//            low = mid + 1       // increase allowed sum
//
//3. Return ans.
//
//
//Possible(maxSum):
//    subarrays = 1
//    currentSum = first element
//
//    Traverse remaining elements:
//         If currentSum + current element > maxSum:
//                subarrays++
//                currentSum = current element
//         Else:
//                currentSum += current element
//
//    Return (subarrays <= k)

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }

        int ans = -1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            if(subarrays(nums, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean subarrays(int[] arr, int k, int maxSum){
        int total = 1;
        int current = arr[0];

        for(int i = 1; i<arr.length; i++){
            if(arr[i] + current > maxSum){
                total++;
                current = arr[i];
            }else{
                current += arr[i];
            }
        }
        return total <= k;
    }
}