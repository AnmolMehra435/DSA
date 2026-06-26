//1. If total flowers required (m × k) is greater than the number of flowers available, return -1.
//
//2. Search for the answer in the range:
//      [minimum bloom day, maximum bloom day]
//
//3. For each mid day:
//      Traverse the array and count consecutive flowers that have bloomed
//      (bloomDay[i] <= mid).
//
//4. Whenever an unbloomed flower is encountered:
//      add count / k bouquets to the total and reset count.
//
//5. After traversal, add bouquets from the last consecutive segment.
//
//6. If total bouquets >= m:
//      mid can be the answer, search left for a smaller day.
//
//7. Otherwise:
//      search right for a larger day.
//
//8. Return the minimum valid day.

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length){
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int flower: bloomDay){
            if(flower > high){
                high = flower;
            }

            if(flower < low){
                low = flower;
            }
        }

        int ans = -1;

        while(low<=high){
            int mid = low + (high - low) / 2;

            int bouquet = countBouquet(mid, bloomDay, k);

            if(bouquet >= m){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public int countBouquet(int mid, int[] bloomDay, int k){
        int total = 0;
        int count = 0;
        for(int blooms: bloomDay){
            if(mid >= blooms){
                count++;
            }else{
                total += count/k;
                count = 0;
            }
        }

        total += count/k;

        return total;
    }
}