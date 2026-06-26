//Algorithm

//1. Search for the answer in the range:
//      [maximum package weight, sum of all package weights].
//
//2. For each mid capacity:
//      Traverse the packages in order and count how many days are needed
//      to ship all packages without exceeding the capacity.
//
//3. If required days <= given days:
//      mid can be the answer, search left for a smaller capacity.
//
//4. Otherwise:
//      search right for a larger capacity.
//
//5. Return the minimum valid capacity.


class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int weight: weights){
            low = Math.max(low, weight);
            high+=weight;
        }

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            int total = countDays(mid, weights);

            if(total <= days){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;

    }
    public int countDays(int capacity, int weights[]){
        int total = 1;
        int count = 0;

        for(int weight: weights){
            if(count + weight > capacity){
                total++;
                count = weight;
            }else{
                count += weight;
            }
        }

        return total;
    }
}