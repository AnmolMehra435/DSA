//ALGORITHM

//1. Search for the answer in the range [1, max(piles)].
//
//2. For each speed = mid, calculate total hours needed:
//      hours += ceil(pile / mid)
//
//3. If total hours <= h:
//      mid can be the answer, search left for a smaller speed.
//
//4. Otherwise:
//      search right for a larger speed.
//
//5. Return the minimum valid speed.

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for(int pile: piles){
            if(pile > max){
                max = pile;
            }
        }

        int low = 1;
        int high = max;
        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            total = 0;

            for(int pile: piles){
                total += (pile + mid - 1) / mid;
            }

            if(total <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}