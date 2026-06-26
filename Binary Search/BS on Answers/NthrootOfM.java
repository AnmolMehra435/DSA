//ALGORITHM

//1. Search for the answer in the range [1, m].
//
//2. Find mid and compute midⁿ.
//
//3. While computing midⁿ, stop immediately if the value exceeds m.
//
//4. If midⁿ == m:
//      return mid
//
//5. If midⁿ < m:
//      search in the right half
//
//6. If midⁿ > m:
//      search in the left half
//
//7. If no such number is found, return -1.

class Solution {
    public int nthRoot(int n, int m) {

        if(m <= 1){
            return m;
        }
        // code here
        int left = 1;
        int right = m;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int power = 1;

            for(int i = 0; i<n; i++){
                power = power * mid;

                if(power > m){
                    break;
                }
            }

            if(power == m){
                return mid;
            }else if(power < m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return -1;
    }
}