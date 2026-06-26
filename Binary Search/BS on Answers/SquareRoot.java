//ALGORITHM
//1. Search space is [1, x].
//
//2. Find mid.
//
//3. If mid² <= x:
//      ans = mid
//      search right (low = mid + 1)
//   Else:
//      search left (high = mid - 1)
//
//4. Continue until low > high.
//
//5. Return ans (largest number whose square <= x).

class Solution {
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }else if(x == 0){
            return 0;
        }

        long low = 1;
        long high = x;
        int ans = 0;

        while(low<=high){
            long mid = low + (high - low) /2;

            if(mid * mid <= x){
                ans = (int) mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
}