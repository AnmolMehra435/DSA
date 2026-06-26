//ALGORITHM

//1. Search for the answer in the range [1, maximum element in the array].
//
//2. For each mid divisor:
//      Calculate the sum of ceil(nums[i] / mid) for all elements.
//
//3. If the total sum <= threshold:
//      mid can be the answer, search left for a smaller divisor.
//
//4. Otherwise:
//      search right for a larger divisor.
//
//5. Return the smallest valid divisor.

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;

        for(int num: nums){
            high = Math.max(high, num);
        }

        int ans = -1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            int count = countTotal(nums, mid);

            if(count <= threshold){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public int countTotal(int[] nums, int mid){
        int total = 0;
        for(int num: nums){
            int curr = (num + mid - 1) / mid;

            total += curr;
        }

        return total;
    }
}